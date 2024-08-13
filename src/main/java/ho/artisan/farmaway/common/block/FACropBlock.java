package ho.artisan.farmaway.common.block;

import ho.artisan.farmaway.common.registry.FABlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FACropBlock extends CropBlock {
	public FACropBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
		if (state.getBlock() instanceof FarmlandBlock farmland) {
			return switch (farmland.getType()) {
				case TERRA -> this.builtInRegistryHolder().is(FABlockTags.TERRA_CROPS);
				case FLAME -> this.builtInRegistryHolder().is(FABlockTags.FLAME_CROPS);
				case SHADOW -> this.builtInRegistryHolder().is(FABlockTags.SHADOW_CROPS);
				case SCARLET -> this.builtInRegistryHolder().is(FABlockTags.SCARLET_CROPS);
				case RAY -> this.builtInRegistryHolder().is(FABlockTags.RAY_CROPS);
				case WIND -> this.builtInRegistryHolder().is(FABlockTags.WIND_CROPS);
				case FROZEN -> this.builtInRegistryHolder().is(FABlockTags.FROZEN_FARMLANDS);
			};
		}
		return false;
	}
}
