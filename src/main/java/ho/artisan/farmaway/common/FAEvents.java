package ho.artisan.farmaway.common;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAEffects;
import net.minecraft.util.RandomSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = FarmAway.MOD_ID)
public class FAEvents {
	@SubscribeEvent
	public static void livingDamagePost(LivingIncomingDamageEvent event) {
		int a = event.getEntity().getEffect(FAEffects.BLUES).getAmplifier();
		if (event.getEntity().hasEffect(FAEffects.BLUES)) {
			int i = RandomSource.create().nextInt(0, 100);
			if (a <= 6) {
				if (i > 50 - a * 5) {
					event.setAmount(0);
				} else {
					event.setAmount(event.getOriginalAmount() * 2);
				}
			} else {
				if (i > 50 - 6 * 5) {
					event.setAmount(0);
				} else {
					event.setAmount(event.getOriginalAmount() * 2);
				}
			}
 		}
	}
}
