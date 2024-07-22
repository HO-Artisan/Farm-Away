package ho.artisan.farm_away.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;

import javax.annotation.Nullable;

public class FarmlandBlock extends Block {
	private static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);
	public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE;
	private final Type type;

	public FarmlandBlock(Properties properties, Type type) {
		super(properties);
		this.type = type;
	}

	@Override
	protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (facing == Direction.UP && !state.canSurvive(level, currentPos)) {
			level.scheduleTick(currentPos, this, 1);
		}
		return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	@Override
	protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		BlockState blockstate = level.getBlockState(pos.above());
		return !blockstate.isSolid() || blockstate.getBlock() instanceof FenceGateBlock || blockstate.getBlock() instanceof MovingPistonBlock;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return !this.defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos())
			? this.type.getBlock().defaultBlockState()
			: super.getStateForPlacement(context);
	}

	@Override
	protected boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Override
	protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (!state.canSurvive(level, pos)) {
			setToOrigin(null, state, level, pos);
		}
	}

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (this.type == Type.SHADOW) {
			return;
		}
		int i = state.getValue(MOISTURE);
		if (!isNearLiquid(level, pos) && (!level.isRainingAt(pos.above()) && this.type.needsWater())) {
			if (i > 0) {
				level.setBlock(pos, state.setValue(MOISTURE, i - 1), 2);
			} else if (!hasCrop(level, pos)) {
				setToOrigin(null, state, level, pos);
			}
		} else if (i < 7) {
			level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
		}
	}

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (!level.isClientSide && CommonHooks.onFarmlandTrample(level, pos, this.type.getBlock().defaultBlockState(), fallDistance, entity)) {
			setToOrigin(entity, state, level, pos);
		}
		super.fallOn(level, state, pos, entity, fallDistance);
	}

	public void setToOrigin(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
		BlockState blockstate = pushEntitiesUp(state, type.getBlock().defaultBlockState(), level, pos);
		level.setBlockAndUpdate(pos, blockstate);
		level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
	}

	private boolean hasCrop(BlockGetter level, BlockPos pos) {
		return level.getBlockState(pos.above()).is(BlockTags.MAINTAINS_FARMLAND);
	}

	private boolean isNearLiquid(LevelReader level, BlockPos pos) {
		for (BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
			if (level.getFluidState(blockPos).is(FluidTags.WATER) && this.type.needsWater()) {
				return true;
			}
			if (level.getFluidState(blockPos).is(FluidTags.LAVA) && this.type == Type.FLAME) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(MOISTURE);
	}

	@Override
	protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
		return false;
	}

	public enum Type {
		TERRA,
		FLAME,
		SHADOW,
		SCARLET,
		RAY,
		WIND;

		public Block getBlock() {
			switch (this) {
				case TERRA -> {
					return Blocks.STONE;
				}
				case FLAME -> {
					return Blocks.NETHERRACK;
				}
				case SHADOW -> {
					return Blocks.END_STONE;
				}
				case SCARLET -> {
					return Blocks.GRANITE;
				}
				case RAY -> {
					return Blocks.ANDESITE;
				}
				case WIND -> {
					return Blocks.DIORITE;
				}
				default -> {
					return Blocks.AIR;
				}
			}
		}

		public boolean needsWater() {
			return this != Type.FLAME && this != Type.SHADOW;
		}
	}
}
