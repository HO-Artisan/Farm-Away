package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.block.*;
import net.minecraft.world.level.block.Block;
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
	public static final DeferredBlock<EmptyRootBlock> EMPTY_ROOT = BLOCKS.register("empty_root", () -> new EmptyRootBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).randomTicks()));
	public static final DeferredBlock<ExplosionPotatoBlock> EXPLOSION_POTATOES = BLOCKS.register("explosion_potatoes", () -> new ExplosionPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<SoftPotatoBlock> SOFT_POTATOES = BLOCKS.register("soft_potatoes", () -> new SoftPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<GerberaPotatoBlock> GERBERA_POTATOES = BLOCKS.register("gerbera_potatoes", () -> new GerberaPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<RosePotatoBlock> ROSE_POTATOES = BLOCKS.register("rose_potatoes", () -> new RosePotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<PhantomBeetrootBlock> PHANTOM_BEETROOTS = BLOCKS.register("phantom_beetroots", () -> new PhantomBeetrootBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS).randomTicks()));
	public static final DeferredBlock<BluesCarrotBlock> BLUES_CARROTS = BLOCKS.register("blues_carrots", () -> new BluesCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<PhantomPotatoBlock> PHANTOM_POTATOES = BLOCKS.register("phantom_potatoes", () -> new PhantomPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<StrongCarrotBlock> STRONG_CARROTS = BLOCKS.register("strong_carrots", () -> new StrongCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<MelonRocketBlock> MELON_ROCKET = BLOCKS.register("melon_rocket", () -> new MelonRocketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON_STEM).randomTicks()));

	// Commons
	public static final DeferredBlock<Block> PHANTOM_DIRT = BLOCKS.register("phantom_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
	public static final DeferredBlock<Block> SOLID_CLOUD = BLOCKS.register("solid_cloud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));

	private static DeferredBlock<FarmlandBlock> registerFarmland(String name, BlockBehaviour.Properties properties) {
		return BLOCKS.register(name, () -> new FarmlandBlock(properties));
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
