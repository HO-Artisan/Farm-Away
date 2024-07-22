package ho.artisan.farmaway.common.block;

import ho.artisan.farmaway.common.registry.FATags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FACropBlock extends CropBlock {
    public FACropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (level.getBlockState(pos.below()).getBlock() instanceof FarmlandBlock farmland) {
            return switch (farmland.type) {
                case TERRA -> state.is(FATags.TERRA_CROP);
                case FLAME -> state.is(FATags.FLAME_CROP);
                case SHADOW -> state.is(FATags.SHADOW_CROP);
                case SCARLET -> state.is(FATags.SCARLET_CROP);
                case RAY -> state.is(FATags.RAY_CROP);
                case WIND -> state.is(FATags.WIND_CROP);
            };
        }
        return false;
    }
}
