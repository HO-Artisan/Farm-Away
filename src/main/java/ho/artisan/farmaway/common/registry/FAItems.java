package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.item.EnhancedHoeItem;
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

	public static DeferredItem<BlockItem> registerBlock(DeferredBlock<? extends Block> block) {
		return ITEMS.registerSimpleBlockItem(block);
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
