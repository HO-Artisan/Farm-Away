package ho.artisan.farm_away;

import ho.artisan.farm_away.common.registry.FABlocks;
import ho.artisan.farm_away.common.registry.FAItems;
import ho.artisan.farm_away.common.registry.FATabs;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(FarmAway.MOD_ID)
public class FarmAway {
	public static final String MOD_ID = "farm_away";

	public FarmAway(IEventBus bus, ModContainer container) {
		FABlocks.register(bus);
		FAItems.register(bus);
		FATabs.register(bus);
	}

	public static ResourceLocation getResourceLocation(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static Component translatable(String domain, String path) {
		return Component.translatable(domain + "." + MOD_ID + "." + path);
	}
}
