package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAMobEffects {
	private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FarmAway.MOD_ID);
	public static final DeferredHolder<MobEffect, MobEffect> BLUES = MOB_EFFECTS.register("blues", () -> new MobEffect(MobEffectCategory.NEUTRAL, 0x1e197f));

	public static void register(IEventBus bus) {
		MOB_EFFECTS.register(bus);
	}
}
