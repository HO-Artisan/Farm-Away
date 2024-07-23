package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.block.BluesCarrotBlock;
import ho.artisan.farmaway.common.block.ExplosionPotatoBlock;
import ho.artisan.farmaway.common.block.FarmlandBlock;
import ho.artisan.farmaway.common.block.StrongCarrotBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unused")
public class FABlocks {
	private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FarmAway.MOD_ID);

	// Farmlands
	public static final DeferredBlock<FarmlandBlock> STONE_FARMLAND = registerFarmland("stone_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).randomTicks());
	public static final DeferredBlock<FarmlandBlock> NETHERRACK_FARMLAND = registerFarmland("netherrack_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK).randomTicks());
	public static final DeferredBlock<FarmlandBlock> END_STONE_FARMLAND = registerFarmland("end_stone_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE));
	//public static final DeferredBlock<FarmlandBlock> DEEPSLATE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> BASALT_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> BLACKSTONE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> SOUL_SOIL_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> CALCITE_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> TUFF_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	//public static final DeferredBlock<FarmlandBlock> SCULK_FARMLAND = BLOCKS.registerSimpleBlock("name", BlockBehaviour.Properties.of());
	public static final DeferredBlock<FarmlandBlock> GRANITE_FARMLAND = registerFarmland("granite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE).randomTicks());
	public static final DeferredBlock<FarmlandBlock> ANDESITE_FARMLAND = registerFarmland("andesite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE).randomTicks());
	public static final DeferredBlock<FarmlandBlock> DIORITE_FARMLAND = registerFarmland("diorite_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE).randomTicks());

	// Crops
	public static final DeferredBlock<ExplosionPotatoBlock> EXPLOSION_POTATO = BLOCKS.register("explosion_potato", () -> new ExplosionPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<BluesCarrotBlock> BLUES_CARROT = BLOCKS.register("blues_carrot", () -> new BluesCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<StrongCarrotBlock> STRONG_CARROT = BLOCKS.register("strong_carrot", () -> new StrongCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));

	private static DeferredBlock<FarmlandBlock> registerFarmland(String name, BlockBehaviour.Properties properties) {
		return BLOCKS.register(name, () -> new FarmlandBlock(properties));
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
