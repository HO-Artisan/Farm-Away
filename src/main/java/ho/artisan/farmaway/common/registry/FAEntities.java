package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAEntities {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FarmAway.MOD_ID);

	public static final DeferredHolder<EntityType<?>, EntityType<ExplosionPotatoEntity>> EXPLOSION_POTATO = ENTITIES.register("explosion_potato", () -> EntityType.Builder.<ExplosionPotatoEntity>of(ExplosionPotatoEntity::new, MobCategory.MISC).build(FarmAway.getResourceLocation("explosion_potato").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<PhantomBeetrootEntity>> PHANTOM_BEETROOT = ENTITIES.register("phantom_beetroot", () -> EntityType.Builder.<PhantomBeetrootEntity>of(PhantomBeetrootEntity::new, MobCategory.MISC).build(FarmAway.getResourceLocation("phantom_beetroot").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<MelonRocketEntity>> MELON_ROCKET = ENTITIES.register("melon_rocket", () -> EntityType.Builder.<MelonRocketEntity>of(MelonRocketEntity::new, MobCategory.MISC).build(FarmAway.getResourceLocation("melon_rocket").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<PotatoLaserEntity>> POTATO_LASER = ENTITIES.register("potato_laser", () -> EntityType.Builder.<PotatoLaserEntity>of(PotatoLaserEntity::new, MobCategory.MISC).build(FarmAway.getResourceLocation("potato_laser").toString()));
	public static final DeferredHolder<EntityType<?>, EntityType<StonatoEntity>> STONATO = ENTITIES.register("stonato", () -> EntityType.Builder.<StonatoEntity>of(StonatoEntity::new, MobCategory.MISC).build(FarmAway.getResourceLocation("stonato").toString()));

	public static void register(IEventBus bus) {
		ENTITIES.register(bus);
	}
}
