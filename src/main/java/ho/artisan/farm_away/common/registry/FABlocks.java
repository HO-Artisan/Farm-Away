package ho.artisan.farm_away.common.registry;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.block.FarmlandBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public class FABlocks {
	private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FarmAway.ID);

	// Farmlands
	public static final DeferredBlock<FarmlandBlock> STONE_FARMLAND = registerFarmland("stone_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), FarmlandBlock.Type.TERRA);
	public static final DeferredBlock<FarmlandBlock> NETHERRACK_FARMLAND = registerFarmland("netherrack_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK), FarmlandBlock.Type.FLAME);
	public static final DeferredBlock<FarmlandBlock> END_STONE_FARMLAND = registerFarmland("end_stone_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE), FarmlandBlock.Type.SHADOW);
	//public static final DeferredBlock<FarmlandBlock> DEEPSLATE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> BASALT_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> BLACKSTONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> SOUL_SOIL_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> CALCITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> TUFF_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> SCULK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	public static final DeferredBlock<FarmlandBlock> GRANITE_FARMLAND = registerFarmland("granite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE), FarmlandBlock.Type.SCARLET);
	public static final DeferredBlock<FarmlandBlock> DIORITE_FARMLAND = registerFarmland("diorite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE), FarmlandBlock.Type.RAY);
	public static final DeferredBlock<FarmlandBlock> ANDESITE_FARMLAND = registerFarmland("andesite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE), FarmlandBlock.Type.SHADOW);

	private static DeferredBlock<FarmlandBlock> registerFarmland(String name, BlockBehaviour.Properties properties, FarmlandBlock.Type type) {
		return BLOCKS.register(name, () -> new FarmlandBlock(properties, type));
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
