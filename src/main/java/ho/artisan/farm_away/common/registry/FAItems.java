package ho.artisan.farm_away.common.registry;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.item.EnhancedHoeItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FarmAway.ID);
	//Tools
	public static final DeferredItem<EnhancedHoeItem> ENHANCED_HOE = ITEMS.register("enhanced_hoe", EnhancedHoeItem::new);

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
