package ho.artisan.farm_away.common.init;

import ho.artisan.farm_away.common.blocks.BlockFarmland;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("farm_away");

    // Farmlands
    public static final Supplier<Block> STONE_FARMLAND = register("stone_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.STONE),BlockFarmland.Type.TERRA);
    public static final Supplier<Block> NETHERRACK_FARMLAND = register("netherrack_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK),BlockFarmland.Type.FLAME);
    public static final Supplier<Block> END_STONE_FARMLAND = register("end_stone_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE),BlockFarmland.Type.SHADOW);
    //public static final Supplier<Block> DEEPSLATE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> BASALT_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> BLACKSTONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> SOUL_SOIL_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> CALCITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> TUFF_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    //public static final Supplier<Block> SCULK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
    public static final Supplier<Block> GRANITE_FARMLAND = register("granite_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE),BlockFarmland.Type.SCARLET);
    public static final Supplier<Block> DIORITE_FARMLAND = register("diorite_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE),BlockFarmland.Type.RAY);
    public static final Supplier<Block> ANDESITE_FARMLAND = register("andesite_farmland",BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE),BlockFarmland.Type.SHADOW);

    private static Supplier<Block> register(String name, BlockBehaviour.Properties properties, BlockFarmland.Type type) {
        return BLOCKS.register(name, () -> new BlockFarmland(properties, type));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
