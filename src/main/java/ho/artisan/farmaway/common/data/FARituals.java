package ho.artisan.farmaway.common.data;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class FARituals {
	public static final ResourceKey<Ritual> POTATO_RITUAL = create("potato_ritual");

	public static void init(BootstrapContext<Ritual> context) {
		context.register(POTATO_RITUAL, new Ritual(
			Blocks.POTATOES.builtInRegistryHolder(),
			Blocks.STONE.builtInRegistryHolder(),
			List.of(Blocks.STONE.builtInRegistryHolder()),
			FABlocks.STONE_FARMLAND
		));
	}

	public static ResourceKey<Ritual> create(String name) {
		return ResourceKey.create(FARegistries.RITUAL, FarmAway.getResourceLocation(name));
	}
}
