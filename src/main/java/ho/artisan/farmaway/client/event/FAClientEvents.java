package ho.artisan.farmaway.client.event;

import ho.artisan.farmaway.client.renderer.MelonRocketRenderer;
import ho.artisan.farmaway.client.renderer.PotatoLaserRenderer;
import ho.artisan.farmaway.common.registry.FAEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class FAClientEvents {
	public static void registerEvents(IEventBus modEventbus) {
		modEventbus.addListener(FAClientEvents::onRegisterRenderers);
	}

	private static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FAEntities.EXPLOSION_POTATO.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FAEntities.PHANTOM_BEETROOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(FAEntities.MELON_ROCKET.get(), MelonRocketRenderer::new);
		event.registerEntityRenderer(FAEntities.POTATO_LASER.get(), PotatoLaserRenderer::new);
		event.registerEntityRenderer(FAEntities.STONATO.get(), ThrownItemRenderer::new);
	}
}
