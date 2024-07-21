package ho.artisan.farm_away.common.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FABlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("farm_away");

    //Farmlands
    public static final Supplier<Block> STONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final Supplier<Block> NETHERRACK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final Supplier<Block> END_STONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> DEEPSLATE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> BASALT_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> BLACKSTONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> SOUL_SOIL_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> CALCITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> TUFF_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> SCULK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final Supplier<Block> GRANITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final Supplier<Block> DIORITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final Supplier<Block> ANDESITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());

}
