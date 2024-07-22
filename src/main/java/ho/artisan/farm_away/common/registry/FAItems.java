package ho.artisan.farm_away.common.registry;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.item.EnhancedHoeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FAItems {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FarmAway.MOD_ID);
	// Tools
	public static final Supplier<Item> ENHANCED_HOE = ITEMS.register("enhanced_hoe", EnhancedHoeItem::new);
	// Blocks
	public static final DeferredItem<BlockItem> STONE_FARMLAND = register(FABlocks.STONE_FARMLAND);
	public static final DeferredItem<BlockItem> NETHERRACK_FARMLAND = register(FABlocks.NETHERRACK_FARMLAND);
	public static final DeferredItem<BlockItem> END_STONE_FARMLAND = register(FABlocks.END_STONE_FARMLAND);
	public static final DeferredItem<BlockItem> GRANITE_FARMLAND = register(FABlocks.GRANITE_FARMLAND);
	public static final DeferredItem<BlockItem> DIORITE_FARMLAND = register(FABlocks.DIORITE_FARMLAND);
	public static final DeferredItem<BlockItem> ANDESITE_FARMLAND = register(FABlocks.ANDESITE_FARMLAND);

	public static DeferredItem<BlockItem> register(DeferredBlock<? extends Block> block) {
		return ITEMS.registerSimpleBlockItem(block);
	}

	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	}
}
