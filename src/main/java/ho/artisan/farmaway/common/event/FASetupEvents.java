package ho.artisan.farmaway.common.event;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = FarmAway.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class FASetupEvents {
	@SubscribeEvent
	private static void onSetup(FMLCommonSetupEvent event) {
		DispenserBlock.registerProjectileBehavior(FAItems.EXPLOSION_POTATO.get());
	}
}
