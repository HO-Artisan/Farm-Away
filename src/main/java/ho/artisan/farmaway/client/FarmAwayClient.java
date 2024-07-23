package ho.artisan.farmaway.client;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = FarmAway.MOD_ID, dist = Dist.CLIENT)
public class FarmAwayClient {
	public FarmAwayClient (IEventBus modEventBus, Dist dist, ModContainer container) {
		if (dist.isClient()) {
			modEventBus.addListener(this::doClientStuff);
		}
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {

		});
	}
}
