package ho.artisan.farmaway.common.data;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class FARituals {
	public static final ResourceKey<Ritual> ICE_CREAM = create("ice_cream");

	public static void init(BootstrapContext<Ritual> context) {
		context.register(ICE_CREAM, new Ritual(
			FABlocks.EMPTY_ROOT,
			FABlocks.SOFT_POTATOES,
			List.of(Blocks.AIR.builtInRegistryHolder(), Blocks.FARMLAND.builtInRegistryHolder(), FABlocks.SOLID_CLOUD),
			FABlocks.ANDESITE_FARMLAND
		));
	}

	public static ResourceKey<Ritual> create(String name) {
		return ResourceKey.create(FARegistries.RITUAL, FarmAway.getResourceLocation(name));
	}
}
