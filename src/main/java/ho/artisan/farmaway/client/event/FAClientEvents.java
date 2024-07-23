package ho.artisan.farmaway.client.event;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = FarmAway.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class FAClientEvents {
	@SubscribeEvent
	private static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FAEntities.EXPLOSION_POTATO.get(), ThrownItemRenderer::new);
	}
}
