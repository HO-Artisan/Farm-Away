package ho.artisan.farmaway.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FAFoods {
	//Potato
	public static final FoodProperties EXPLOSION_POTATO = new FoodProperties.Builder().nutrition(10).saturationModifier(0).build();
	public static final FoodProperties GERBERA_POTATO = new FoodProperties.Builder().nutrition(10).saturationModifier(0).build();
	public static final FoodProperties SOFT_POTATO = new FoodProperties.Builder().alwaysEdible().nutrition(0).saturationModifier(2).build();
	public static final FoodProperties ROSE_POTATO = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
	public static final FoodProperties PHANTOM_POTATO = new FoodProperties.Builder().alwaysEdible().nutrition(0).saturationModifier(0)
		.effect(() -> new MobEffectInstance(FAMobEffects.PHANTOM, 2000), 1)
		.build();
	//Carrot
	public static final FoodProperties STRONG_CARROT = new FoodProperties.Builder().nutrition(2).saturationModifier(2).build();
	public static final FoodProperties BLUES_CARROT = new FoodProperties.Builder().alwaysEdible().nutrition(0).saturationModifier(0).
		effect(() -> new MobEffectInstance(FAMobEffects.BLUES, 2000), 1)
		.build();
	public static final FoodProperties DRILL_CARROT = new FoodProperties.Builder().nutrition(2).saturationModifier(2)
		.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 2000), 1)
		.build();
	public static final FoodProperties DISTORTED_CARROT = new FoodProperties.Builder().nutrition(0).saturationModifier(0)
		.effect(() -> new MobEffectInstance(FAMobEffects.TWIST, 2000), 1)
		.build();
	public static final FoodProperties HOT_CARROT = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
	//Beetroot
	public static final FoodProperties PHANTOM_BEETROOT = new FoodProperties.Builder().nutrition(0).saturationModifier(0).build();
	//Melon
	public static final FoodProperties FROZEN_MELON = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F)
		.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2000, 1), 0.5f)
		.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2000), 1)
		.build();
}
