package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAEntities {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FarmAway.MOD_ID);
}
