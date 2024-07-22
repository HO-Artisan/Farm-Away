package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.block.FACropBlock;
import ho.artisan.farmaway.common.block.FarmlandBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public class FABlocks {
	private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FarmAway.MOD_ID);

	// Farmlands
	public static final DeferredBlock<FarmlandBlock> STONE_FARMLAND = registerFarmland("stone_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).randomTicks(), FarmlandBlock.Type.TERRA);
	public static final DeferredBlock<FarmlandBlock> NETHERRACK_FARMLAND = registerFarmland("netherrack_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).randomTicks(), FarmlandBlock.Type.FLAME);
	public static final DeferredBlock<FarmlandBlock> END_STONE_FARMLAND = registerFarmland("end_stone_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE), FarmlandBlock.Type.SHADOW);
	//public static final DeferredBlock<FarmlandBlock> DEEPSLATE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> BASALT_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> BLACKSTONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> SOUL_SOIL_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> CALCITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> TUFF_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> SCULK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	public static final DeferredBlock<FarmlandBlock> GRANITE_FARMLAND = registerFarmland("granite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).randomTicks(), FarmlandBlock.Type.SCARLET);
	public static final DeferredBlock<FarmlandBlock> ANDESITE_FARMLAND = registerFarmland("andesite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).randomTicks(), FarmlandBlock.Type.RAY);
	public static final DeferredBlock<FarmlandBlock> DIORITE_FARMLAND = registerFarmland("diorite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).randomTicks(), FarmlandBlock.Type.WIND);
	public static final DeferredBlock<FACropBlock> EXPLOSION_POTATO = registerCrop("explosion_potato", BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks(), 3);
	public static final DeferredBlock<FACropBlock> BLUE_CARROT = registerCrop("blue_carrot", BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks(), 3);

	private static DeferredBlock<FarmlandBlock> registerFarmland(String name, BlockBehaviour.Properties properties, FarmlandBlock.Type type) {
		return BLOCKS.register(name, () -> new FarmlandBlock(properties, type));
	}

	private static DeferredBlock<FACropBlock> registerCrop(String name, BlockBehaviour.Properties properties, int max_age) {
		return BLOCKS.register(name, () -> new FACropBlock(properties, max_age));
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
