package ho.artisan.farm_away.common.init;

import ho.artisan.farm_away.common.items.EnhancedHoeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("farm_away");
    //Tools
    public static final Supplier<Item> ENHANCED_HOE = ITEMS.register("enhanced_hoe", EnhancedHoeItem::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
