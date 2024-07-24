package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.item.BluesCarrotItem;
import ho.artisan.farmaway.common.item.EnhancedHoeItem;
import ho.artisan.farmaway.common.item.ExplosionPotatoItem;
import ho.artisan.farmaway.common.item.StrongCarrotItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FAItems {
	private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FarmAway.MOD_ID);

	// Tools
	public static final DeferredItem<EnhancedHoeItem> ENHANCED_HOE = ITEMS.register("enhanced_hoe", () -> new EnhancedHoeItem(Tiers.NETHERITE, new Item.Properties().rarity(Rarity.RARE).fireResistant().attributes(HoeItem.createAttributes(Tiers.NETHERITE, -4.0F, 0.0F))));

	// Blocks
	public static final DeferredItem<BlockItem> STONE_FARMLAND = registerBlock(FABlocks.STONE_FARMLAND);
	public static final DeferredItem<BlockItem> NETHERRACK_FARMLAND = registerBlock(FABlocks.NETHERRACK_FARMLAND);
	public static final DeferredItem<BlockItem> END_STONE_FARMLAND = registerBlock(FABlocks.END_STONE_FARMLAND);
	public static final DeferredItem<BlockItem> GRANITE_FARMLAND = registerBlock(FABlocks.GRANITE_FARMLAND);
	public static final DeferredItem<BlockItem> ANDESITE_FARMLAND = registerBlock(FABlocks.ANDESITE_FARMLAND);
	public static final DeferredItem<BlockItem> DIORITE_FARMLAND = registerBlock(FABlocks.DIORITE_FARMLAND);
	public static final DeferredItem<ExplosionPotatoItem> EXPLOSION_POTATO = ITEMS.register("explosion_potato", () -> new ExplosionPotatoItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0).build())));
	public static final DeferredItem<BluesCarrotItem> BLUES_CARROT = ITEMS.register("blues_carrot", () -> new BluesCarrotItem(FABlocks.BLUES_CARROTS.get(), new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(6).saturationModifier(0).effect(() -> new MobEffectInstance(FAMobEffects.BLUES, 2000), 1).build())));
	public static final DeferredItem<StrongCarrotItem> STRONG_CARROT = ITEMS.register("strong_carrot", () -> new StrongCarrotItem(FABlocks.STRONG_CARROTS.get(), new Item.Properties().attributes(SwordItem.createAttributes(Tiers.GOLD, 1.0F, 5.68F)).durability(300).food(new FoodProperties.Builder().nutrition(2).saturationModifier(2).build())));

	public static DeferredItem<BlockItem> registerBlock(DeferredBlock<? extends Block> block) {
		return ITEMS.registerSimpleBlockItem(block);
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
