package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class FATabs {
	private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmAway.MOD_ID);
	public static final Supplier<CreativeModeTab> TAB = TABS.register("main", () -> CreativeModeTab.builder()
		.title(FarmAway.translatable("itemGroup", "main"))
		.icon(FAItems.ENHANCED_HOE::toStack)
		.displayItems((params, output) -> BuiltInRegistries.ITEM.stream().filter(i -> BuiltInRegistries.ITEM.getKey(i).getNamespace().equals(FarmAway.MOD_ID)).forEach(output::accept))
		.build()
	);

	public static void register(IEventBus bus) {
		TABS.register(bus);
	}
}
