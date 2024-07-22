package ho.artisan.farmaway.common.datagen.model;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FABlockStateProvider extends BlockStateProvider {
	// render types
	private static final ResourceLocation SOLID = ResourceLocation.withDefaultNamespace("solid");
	private static final ResourceLocation CUTOUT = ResourceLocation.withDefaultNamespace("cutout");
	private static final ResourceLocation CUTOUT_MIPPED = ResourceLocation.withDefaultNamespace("cutout_mipped");
	private static final ResourceLocation TRANSLUCENT = ResourceLocation.withDefaultNamespace("translucent");

	public FABlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, FarmAway.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		farmland(FABlocks.STONE_FARMLAND.get(), Blocks.STONE);
		farmland(FABlocks.NETHERRACK_FARMLAND.get(), Blocks.NETHERRACK);
		farmland(FABlocks.END_STONE_FARMLAND.get(), Blocks.END_STONE);
		farmland(FABlocks.GRANITE_FARMLAND.get(), Blocks.GRANITE);
		farmland(FABlocks.ANDESITE_FARMLAND.get(), Blocks.ANDESITE);
		farmland(FABlocks.DIORITE_FARMLAND.get(), Blocks.DIORITE);
	}

	private void farmland(Block farmland, Block dirt) {
		ModelFile normal = models().withExistingParent(name(farmland), "template_farmland")
			.texture("dirt", blockTexture(dirt))
			.texture("top", blockTexture(farmland));
		ModelFile moist = models().withExistingParent(name(farmland) + "_moist", "template_farmland")
			.texture("dirt", blockTexture(dirt))
			.texture("top", blockTexture(farmland).withSuffix("_moist"));
		getVariantBuilder(farmland).forAllStates(state -> ConfiguredModel.builder().modelFile(state.getValue(BlockStateProperties.MOISTURE) < 7 ? normal : moist).build());
	}


	private ResourceLocation key(Block block) {
		return BuiltInRegistries.BLOCK.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}
}
