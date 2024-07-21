package ho.artisan.farm_away.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.FarmlandWaterManager;
import net.neoforged.neoforge.common.ticket.ChunkTicketManager;
import net.neoforged.neoforge.common.ticket.SimpleTicket;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Iterator;

public class BlockFarmland extends FarmBlock {
    private Type type;

    public BlockFarmland(Type type) {
        super(BlockBehaviour.Properties.of()
                .randomTicks()
                .strength(1.5f, 6.0f)
                .sound(SoundType.GRAVEL)
                .isViewBlocking(BlockFarmland::always)
                .isSuffocating(BlockFarmland::always)
        );
        this.type = type;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            turnToOrigin(null, state, level, pos);
        }

    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (i > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, i - 1), 2);
            } else if (!shouldMaintainFarmland(level, pos)) {
                turnToDirt(null, state, level, pos);
            }
        } else if (i < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, 7), 2);
        }

    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!level.isClientSide && CommonHooks.onFarmlandTrample(level, pos, Blocks.DIRT.defaultBlockState(), fallDistance, entity)) {
            turnToDirt(entity, state, level, pos);
        }

        super.fallOn(level, state, pos, entity, fallDistance);
    }

    public void turnToOrigin(@Nullable Entity entity, BlockState state, Level level, BlockPos pos) {
        BlockState blockstate = pushEntitiesUp(state, Type.of(type).defaultBlockState(), level, pos);
        level.setBlockAndUpdate(pos, blockstate);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, blockstate));
    }

    private boolean shouldMaintainFarmland(BlockGetter level, BlockPos pos) {
        return level.getBlockState(pos.above()).is(BlockTags.MAINTAINS_FARMLAND);
    }

    private boolean isNearWater(LevelReader level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        Iterator var3 = BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4)).iterator();

        BlockPos blockpos;
        do {
            if (!var3.hasNext()) {
                if (type.equals(Type.NETHERRACK)) return false;
                return FarmlandWaterManager.hasBlockWaterTicket(level, pos);
            }

            blockpos = (BlockPos)var3.next();
        } while(!state.canBeHydrated(level, pos, level.getFluidState(blockpos), blockpos));

        return true;
    }

    private static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

    public enum Type {
        STONE,
        NETHERRACK,
        ENDSTONE,
        GRANITE,
        DIORITE,
        ANDESITE;

        public static Block of(Type type) {
            switch (type) {
                case NETHERRACK -> {
                    return Blocks.NETHERRACK;
                }
                case ENDSTONE -> {
                    return Blocks.END_STONE;
                }
                case GRANITE -> {
                    return Blocks.GRANITE;
                }
                case DIORITE -> {
                    return Blocks.DIORITE;
                }
                case ANDESITE -> {
                    return Blocks.ANDESITE;
                }
                default -> {
                    return  Blocks.STONE;
                }
            }
        }
    }
}
