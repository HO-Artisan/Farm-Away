package ho.artisan.farmaway;

import ho.artisan.farmaway.client.event.FAClientEvents;
import ho.artisan.farmaway.client.event.FAClientSetupEvents;
import ho.artisan.farmaway.common.data.FARegistries;
import ho.artisan.farmaway.common.event.FAEvents;
import ho.artisan.farmaway.common.event.FASetupEvents;
import ho.artisan.farmaway.common.registry.*;
import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(FarmAway.MOD_ID)
public class FarmAway {
	public static final String MOD_ID = "farm_away";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public FarmAway(IEventBus modEventBus) {
		IEventBus forgeEventBus = NeoForge.EVENT_BUS;

		if (FMLLoader.getDist().isClient()) {
			FAClientSetupEvents.registerEvents(modEventBus);
			FAClientEvents.registerEvents(modEventBus);
		}

		FASetupEvents.registerEvents(modEventBus);
		FAEvents.registerEvents(forgeEventBus);

		modEventBus.addListener(DataPackRegistryEvent.NewRegistry.class, (event) -> event.dataPackRegistry(FARegistries.RITUAL, Ritual.CODEC, Ritual.CODEC));

		FABlocks.register(modEventBus);
		FAItems.register(modEventBus);
		FATabs.register(modEventBus);
		FAEntities.register(modEventBus);
		FAMobEffects.register(modEventBus);
	}

	public static ResourceLocation getResourceLocation(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static Component translatable(String type, String path) {
		return Component.translatable(descriptionId(type, path));
	}

	public static String descriptionId(String type, String path) {
		return Util.makeDescriptionId(type, getResourceLocation(path));
	}
}
