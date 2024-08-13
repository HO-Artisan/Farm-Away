package ho.artisan.farmaway.common.block;

import ho.artisan.farmaway.common.registry.FABlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

	public FarmlandBlock(Properties properties) {
		super(properties);
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
			? this.getType().getOriginalBlock().defaultBlockState()
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
			turnToOrigin(null, state, level, pos);
		}
	}

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (this.getType() == Type.SHADOW) {
			return;
		}
		int i = state.getValue(MOISTURE);
		if (!isNearFluid(level, pos)) {
			if (i > 0) {
				level.setBlock(pos, state.setValue(MOISTURE, i - 1), 2);
			} else if (!hasCrop(level, pos)) {
				turnToOrigin(null, state, level, pos);
			}
		} else if (i < 7) {
			level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
		}
	}

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		if (!level.isClientSide && CommonHooks.onFarmlandTrample(level, pos, this.getType().getOriginalBlock().defaultBlockState(), fallDistance, entity)) {
			turnToOrigin(entity, state, level, pos);
		}
		super.fallOn(level, state, pos, entity, fallDistance);
	}

	public void turnToOrigin(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
		BlockState blockstate = pushEntitiesUp(state, getType().getOriginalBlock().defaultBlockState(), level, pos);
		level.setBlockAndUpdate(pos, blockstate);
		level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
	}

	private boolean hasCrop(BlockGetter level, BlockPos pos) {
		return level.getBlockState(pos.above()).is(BlockTags.MAINTAINS_FARMLAND);
	}

	private boolean isNearFluid(ServerLevel level, BlockPos pos) {
		if (level.isRainingAt(pos.above()) && this.getType().needsWater()) {
			return true;
		}
		for (BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
			if (level.getFluidState(blockPos).is(FluidTags.WATER) && this.getType().needsWater()) {
				return true;
			}
			if (level.getFluidState(blockPos).is(FluidTags.LAVA) && this.getType() == Type.FLAME) {
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

	public Type getType() {
		if (this.defaultBlockState().is(FABlockTags.TERRA_FARMLANDS)) {
			return Type.TERRA;
		}
		if (this.defaultBlockState().is(FABlockTags.FLAME_FARMLANDS)) {
			return Type.FLAME;
		}
		if (this.defaultBlockState().is(FABlockTags.SHADOW_FARMLANDS)) {
			return Type.SHADOW;
		}
		if (this.defaultBlockState().is(FABlockTags.SCARLET_FARMLANDS)) {
			return Type.SCARLET;
		}
		if (this.defaultBlockState().is(FABlockTags.RAY_FARMLANDS)) {
			return Type.RAY;
		}
		if (this.defaultBlockState().is(FABlockTags.WIND_FARMLANDS)) {
			return Type.WIND;
		}
		if (this.defaultBlockState().is(FABlockTags.FROZEN_FARMLANDS)) {
			return Type.FROZEN;
		}
		throw new RuntimeException("Find a farmland without a type");
	}

	public enum Type {
		TERRA(ResourceLocation.withDefaultNamespace("stone")),
		FLAME(ResourceLocation.withDefaultNamespace("netherrack")),
		SHADOW(ResourceLocation.withDefaultNamespace("end_stone")),
		SCARLET(ResourceLocation.withDefaultNamespace("granite")),
		RAY(ResourceLocation.withDefaultNamespace("andesite")),
		WIND(ResourceLocation.withDefaultNamespace("diorite")),
		FROZEN(ResourceLocation.withDefaultNamespace("blue_ice"));

		private final ResourceLocation originalBlockId;

		Type(ResourceLocation originalBlockId) {
			this.originalBlockId = originalBlockId;
		}

		public Block getOriginalBlock() {
			return BuiltInRegistries.BLOCK.get(originalBlockId);
		}

		public boolean needsWater() {
			return this != Type.FLAME && this != Type.SHADOW;
		}
	}
}
