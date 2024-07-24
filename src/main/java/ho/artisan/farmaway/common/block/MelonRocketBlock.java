package ho.artisan.farmaway.common.block;

import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.world.level.ItemLike;

public class MelonRocketBlock extends FACropBlock {
	public MelonRocketBlock(Properties properties) {
		super(properties);
	}

	protected ItemLike getBaseSeedId() {
		return FAItems.MELON_ROCKET.get();
	}
}
