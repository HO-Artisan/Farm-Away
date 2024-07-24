package ho.artisan.farmaway.common.event;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = FarmAway.MOD_ID)
public class FAEvents {
	@SubscribeEvent
	private static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
		if (event.getEntity().hasEffect(FAMobEffects.BLUES)) {
			MobEffectInstance instance = event.getEntity().getEffect(FAMobEffects.BLUES);
			if (instance != null) {
				int amplifier = Math.min(instance.getAmplifier(), 6);
				if (event.getEntity().getRandom().nextInt(100) > 50 - amplifier * 5) {
					event.setAmount(0);
				} else {
					event.setAmount(event.getOriginalAmount() * 2);
				}
			}
		}
	}
}
