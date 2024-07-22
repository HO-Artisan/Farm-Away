package ho.artisan.farm_away.common.init;

import ho.artisan.farm_away.common.blocks.FarmlandBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public class ModBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("farm_away");

    // Farmlands
    public static final DeferredBlock<Block> STONE_FARMLAND = register("stone_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), FarmlandBlock.Type.TERRA);
    public static final DeferredBlock<Block> NETHERRACK_FARMLAND = register("netherrack_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK), FarmlandBlock.Type.FLAME);
    public static final DeferredBlock<Block> END_STONE_FARMLAND = register("end_stone_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE), FarmlandBlock.Type.SHADOW);
    //public static final Supplier<Block> DEEPSLATE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> BASALT_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> BLACKSTONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> SOUL_SOIL_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> CALCITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> TUFF_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> SCULK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final DeferredBlock<Block> GRANITE_FARMLAND = register("granite_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE), FarmlandBlock.Type.SCARLET);
    public static final DeferredBlock<Block> DIORITE_FARMLAND = register("diorite_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE), FarmlandBlock.Type.RAY);
    public static final DeferredBlock<Block> ANDESITE_FARMLAND = register("andesite_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE), FarmlandBlock.Type.SHADOW);

    private static DeferredBlock<Block> register(String name, BlockBehaviour.Properties properties, FarmlandBlock.Type type) {
        return BLOCKS.register(name, () -> new FarmlandBlock(properties, type));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
