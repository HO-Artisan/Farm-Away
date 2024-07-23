package ho.artisan.farmaway.common.block;

import ho.artisan.farmaway.common.registry.FABlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FACropBlock extends CropBlock {
    private final int max_age;
    public FACropBlock(Properties properties, int max_age) {
        super(properties);
        this.max_age = max_age;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (level.getBlockState(pos.below()).getBlock() instanceof FarmlandBlock farmland) {
            return switch (farmland.getType()) {
                case TERRA -> state.is(FABlockTags.TERRA_CROPS);
                case FLAME -> state.is(FABlockTags.FLAME_CROPS);
                case SHADOW -> state.is(FABlockTags.SHADOW_CROPS);
                case SCARLET -> state.is(FABlockTags.SCARLET_CROPS);
                case RAY -> state.is(FABlockTags.RAY_CROPS);
                case WIND -> state.is(FABlockTags.WIND_CROPS);
            };
        }
        return false;
    }

    @Override
    public int getMaxAge() {
        return this.max_age;
    }
}
