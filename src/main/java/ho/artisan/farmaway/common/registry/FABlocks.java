package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.block.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
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
	public static final DeferredBlock<FarmlandBlock> FROZEN_FARMLAND = registerFarmland("frozen_farmland", BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_ICE).randomTicks());
	// Crops
	public static final DeferredBlock<EmptyRootBlock> EMPTY_ROOT = BLOCKS.register("empty_root", () -> new EmptyRootBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).randomTicks()));
	//Potatoes
	public static final DeferredBlock<ExplosionPotatoBlock> EXPLOSION_POTATOES = BLOCKS.register("explosion_potatoes", () -> new ExplosionPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<SoftPotatoBlock> SOFT_POTATOES = BLOCKS.register("soft_potatoes", () -> new SoftPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<StonatoBlock> STONATOES = BLOCKS.register("stonatoes", () -> new StonatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<GerberaPotatoBlock> GERBERA_POTATOES = BLOCKS.register("gerbera_potatoes", () -> new GerberaPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<RosePotatoBlock> ROSE_POTATOES = BLOCKS.register("rose_potatoes", () -> new RosePotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	public static final DeferredBlock<PhantomPotatoBlock> PHANTOM_POTATOES = BLOCKS.register("phantom_potatoes", () -> new PhantomPotatoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).randomTicks()));
	//Beetroots
	public static final DeferredBlock<PhantomBeetrootBlock> PHANTOM_BEETROOTS = BLOCKS.register("phantom_beetroots", () -> new PhantomBeetrootBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS).randomTicks()));
	//Carrots
	public static final DeferredBlock<BluesCarrotBlock> BLUES_CARROTS = BLOCKS.register("blues_carrots", () -> new BluesCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<RodriguesCarrotBlock> RODRIGUES_CARROTS = BLOCKS.register("rodrigues_carrots", () -> new RodriguesCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<DrillCarrotBlock> DRILL_CARROTS = BLOCKS.register("drill_carrots", () -> new DrillCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<DistortedCarrotBlock> DISTORTED_CARROTS = BLOCKS.register("distorted_carrots", () -> new DistortedCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<HotCarrotBlock> HOT_CARROTS = BLOCKS.register("hot_carrots", () -> new HotCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	public static final DeferredBlock<StrongCarrotBlock> STRONG_CARROTS = BLOCKS.register("strong_carrots", () -> new StrongCarrotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CARROTS).randomTicks()));
	//Melons
	public static final DeferredBlock<MelonRocketBlock> MELON_ROCKET = BLOCKS.register("melon_rocket", () -> new MelonRocketBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON_STEM).randomTicks()));
	public static final DeferredBlock<FrozenMelonBlock> FROZEN_MELON = BLOCKS.register("frozen_melon", () -> new FrozenMelonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MELON).randomTicks()));
	public static final DeferredBlock<AttachedMelonStemBlock> ATTACHED_FROZEN_MELON_STEM = BLOCKS.register("attached_frozen_melon_stem", () -> new AttachedMelonStemBlock("frozen", BlockBehaviour.Properties.ofFullCopy(Blocks.ATTACHED_MELON_STEM)));
	public static final DeferredBlock<MelonStemBlock> FROZEN_MELON_STEM = BLOCKS.register("frozen_melon_stem", () -> new MelonStemBlock("frozen", BlockBehaviour.Properties.ofFullCopy(Blocks.MELON_STEM)));
	// Commons
	public static final DeferredBlock<Block> PHANTOM_DIRT = BLOCKS.register("phantom_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
	public static final DeferredBlock<Block> SOLID_CLOUD = BLOCKS.register("solid_cloud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));

	private static DeferredBlock<FarmlandBlock> registerFarmland(String name, BlockBehaviour.Properties properties) {
		return BLOCKS.register(name, () -> new FarmlandBlock(properties));
	}

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}

	public static ResourceKey<Block> blockKey(String id) {
		return ResourceKey.create(Registries.BLOCK, FarmAway.getResourceLocation(id));
	}

	public static ResourceKey<Item> itemKey(String id) {
		return ResourceKey.create(Registries.ITEM, FarmAway.getResourceLocation(id));
	}
}
