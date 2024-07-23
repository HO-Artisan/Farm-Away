package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.entity.ExplosionPotatoEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAEntities {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FarmAway.MOD_ID);
	public static final DeferredHolder<EntityType<?>, EntityType<ExplosionPotatoEntity>> EXPLOSION_POTATO = ENTITIES.register("explosion_potato", () -> EntityType.Builder.<ExplosionPotatoEntity>of(ExplosionPotatoEntity::new, MobCategory.MISC).build(FarmAway.MOD_ID + "explosion_potato"));
}
