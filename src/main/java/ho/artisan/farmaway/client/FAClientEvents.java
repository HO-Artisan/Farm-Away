package ho.artisan.farmaway.client;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = FarmAway.MOD_ID, value = Dist.CLIENT)
public class FAClientEvents {
	@SubscribeEvent
	public static void onRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FAEntities.EXPLOSION_POTATO.get(), ThrownItemRenderer::new);
	}
}
