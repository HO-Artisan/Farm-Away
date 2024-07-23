package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.effect.BluesEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAEffects {
	private static DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FarmAway.MOD_ID);
	public static Holder<MobEffect> BLUES = EFFECTS.register("blues", BluesEffect::new);
	public static void register(IEventBus bus) {
		EFFECTS.register(bus);
	}
}
