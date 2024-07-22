package ho.artisan.farm_away.common.registry;

import ho.artisan.farm_away.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class FATabs {
	private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,FarmAway.MOD_ID);
	public static final Supplier<CreativeModeTab> TAB = TABS.register("main", () -> CreativeModeTab.builder()
		.title(FarmAway.translatable("itemGroup","main"))
		.icon(FAItems.ENHANCED_HOE::toStack)
		.displayItems((params, output) -> {
			output.accept(FAItems.ENHANCED_HOE);
			output.accept(FAItems.STONE_FARMLAND);
			output.accept(FAItems.NETHERRACK_FARMLAND);
			output.accept(FAItems.END_STONE_FARMLAND);
			output.accept(FAItems.GRANITE_FARMLAND);
			output.accept(FAItems.DIORITE_FARMLAND);
			output.accept(FAItems.ANDESITE_FARMLAND);
		})
		.build()
	);
	public static void register(IEventBus bus) {
		TABS.register(bus);
	}
}
