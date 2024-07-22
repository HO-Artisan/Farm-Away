package ho.artisan.farm_away.common.init;

import ho.artisan.farm_away.common.items.EnhancedHoeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("farm_away");
    // Tools
    public static final Supplier<Item> ENHANCED_HOE = ITEMS.register("enhanced_hoe", EnhancedHoeItem::new);
    // Blocks
    public static final DeferredItem<BlockItem> STONE_FARMLAND = register(ModBlocks.STONE_FARMLAND);
    public static final DeferredItem<BlockItem> NETHERRACK_FARMLAND = register(ModBlocks.NETHERRACK_FARMLAND);
    public static final DeferredItem<BlockItem> END_STONE_FARMLAND = register(ModBlocks.END_STONE_FARMLAND);
    public static final DeferredItem<BlockItem> GRANITE_FARMLAND = register(ModBlocks.GRANITE_FARMLAND);
    public static final DeferredItem<BlockItem> DIORITE_FARMLAND = register(ModBlocks.DIORITE_FARMLAND);
    public static final DeferredItem<BlockItem> ANDESITE_FARMLAND = register(ModBlocks.ANDESITE_FARMLAND);

    public static DeferredItem<BlockItem> register(DeferredBlock<Block> block) {
        return ITEMS.registerSimpleBlockItem(block);
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
