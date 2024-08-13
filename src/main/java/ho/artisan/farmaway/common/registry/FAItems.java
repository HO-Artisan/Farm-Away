package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.item.*;
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
	// Farmland
	public static final DeferredItem<BlockItem> STONE_FARMLAND = registerBlock(FABlocks.STONE_FARMLAND);
	public static final DeferredItem<BlockItem> NETHERRACK_FARMLAND = registerBlock(FABlocks.NETHERRACK_FARMLAND);
	public static final DeferredItem<BlockItem> END_STONE_FARMLAND = registerBlock(FABlocks.END_STONE_FARMLAND);
	public static final DeferredItem<BlockItem> GRANITE_FARMLAND = registerBlock(FABlocks.GRANITE_FARMLAND);
	public static final DeferredItem<BlockItem> ANDESITE_FARMLAND = registerBlock(FABlocks.ANDESITE_FARMLAND);
	public static final DeferredItem<BlockItem> DIORITE_FARMLAND = registerBlock(FABlocks.DIORITE_FARMLAND);
	//Potato
	public static final DeferredItem<ExplosionPotatoItem> EXPLOSION_POTATO = ITEMS.register("explosion_potato", () -> new ExplosionPotatoItem(new Item.Properties().food(FAFoods.EXPLOSION_POTATO)));
	public static final DeferredItem<StonatoItem> STONATO = ITEMS.register("stonato", () -> new StonatoItem(FABlocks.STONATOES.get(), new Item.Properties()));
	public static final DeferredItem<GerberaPotatoItem> GERBERA_POTATO = ITEMS.register("gerbera_potato", () -> new GerberaPotatoItem(FABlocks.GERBERA_POTATOES.get(), new Item.Properties().food(FAFoods.GERBERA_POTATO)));
	public static final DeferredItem<SoftPotatoItem> SOFT_POTATO = ITEMS.register("soft_potato", () -> new SoftPotatoItem(FABlocks.SOFT_POTATOES.get(), new Item.Properties().food(FAFoods.SOFT_POTATO)));
	public static final DeferredItem<RosePotatoItem> ROSE_POTATO = ITEMS.register("rose_potato", () -> new RosePotatoItem(FABlocks.ROSE_POTATOES.get(), new Item.Properties().food(FAFoods.ROSE_POTATO)));
	public static final DeferredItem<ItemNameBlockItem> PHANTOM_POTATO = ITEMS.register("phantom_potato", () -> new ItemNameBlockItem(FABlocks.PHANTOM_POTATOES.get(), new Item.Properties().food(FAFoods.PHANTOM_POTATO)));
	//Carrot
	public static final DeferredItem<StrongCarrotItem> STRONG_CARROT = ITEMS.register("strong_carrot", () -> new StrongCarrotItem(FABlocks.STRONG_CARROTS.get(), new Item.Properties().food(FAFoods.STRONG_CARROT)));
	public static final DeferredItem<RodriguesCarrotItem> RODRIGUES_CARROT = ITEMS.register("rodrigues_carrot", () -> new RodriguesCarrotItem(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
	public static final DeferredItem<BluesCarrotItem> BLUES_CARROT = ITEMS.register("blues_carrot", () -> new BluesCarrotItem(FABlocks.BLUES_CARROTS.get(), new Item.Properties().food(FAFoods.BLUES_CARROT)));
	public static final DeferredItem<DrillCarrotItem> DRILL_CARROT = ITEMS.register("drill_carrot", () -> new DrillCarrotItem(FABlocks.DRILL_CARROTS.get(), new Item.Properties().food(FAFoods.DRILL_CARROT)));
	public static final DeferredItem<DistortedCarrotItem> DISTORTED_CARROT = ITEMS.register("distorted_carrot", () -> new DistortedCarrotItem(FABlocks.DISTORTED_CARROTS.get(), new Item.Properties().food(FAFoods.DISTORTED_CARROT)));
	public static final DeferredItem<HotCarrotItem> HOT_CARROT = ITEMS.register("hot_carrot", () -> new HotCarrotItem(FABlocks.HOT_CARROTS.get(), new Item.Properties().food(FAFoods.HOT_CARROT)));
	//Melon
	public static final DeferredItem<MelonRocketItem> MELON_ROCKET = ITEMS.register("melon_rocket", () -> new MelonRocketItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0).build())));
	public static final DeferredItem<ItemNameBlockItem> MELON_ROCKET_SEED = ITEMS.register("melon_rocket_seed", () -> new ItemNameBlockItem(FABlocks.MELON_ROCKET.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> FROZEN_MELON_SEED = ITEMS.register("frozen_melon_seed", () -> new ItemNameBlockItem(FABlocks.FROZEN_MELON_STEM.get(), new Item.Properties()));
	public static final DeferredItem<Item> FROZEN_MELON_SLICE = ITEMS.register("frozen_melon_slice", () -> new Item(new Item.Properties().food(FAFoods.FROZEN_MELON)));
	//Beetroot
	public static final DeferredItem<PhantomBeetrootItem> PHANTOM_BEETROOT = ITEMS.register("phantom_beetroot", () -> new PhantomBeetrootItem(FABlocks.PHANTOM_BEETROOTS.get(), new Item.Properties().food(FAFoods.PHANTOM_BEETROOT)));
	//Others
	public static final DeferredItem<BlockItem> PHANTOM_DIRT = registerBlock(FABlocks.PHANTOM_DIRT);
	public static final DeferredItem<BlockItem> SOLID_CLOUD = registerBlock(FABlocks.SOLID_CLOUD);
	public static final DeferredItem<BlockItem> EMPTY_ROOT = registerBlock(FABlocks.EMPTY_ROOT);

	private static DeferredItem<BlockItem> registerBlock(DeferredBlock<? extends Block> block) {
		return ITEMS.registerSimpleBlockItem(block);
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
