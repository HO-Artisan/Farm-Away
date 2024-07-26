package ho.artisan.farmaway.datagen.model;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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
		crop(FABlocks.PHANTOM_BEETROOTS.get(), 3, BlockStateProperties.AGE_7);
		crop(FABlocks.EXPLOSION_POTATOES.get(), 3, BlockStateProperties.AGE_7);
//		crop(FABlocks.SOFT_POTATOES.get(), 3, BlockStateProperties.AGE_7);
//		crop(FABlocks.ROSE_POTATOES.get(), 3, BlockStateProperties.AGE_7);
		crop(FABlocks.BLUES_CARROTS.get(), 3, BlockStateProperties.AGE_15);
		crop(FABlocks.STRONG_CARROTS.get(), 3, BlockStateProperties.AGE_3);
//		crop(FABlocks.PHANTOM_POTATOES.get(), 2, BlockStateProperties.AGE_3);
		simpleBlock(FABlocks.PHANTOM_DIRT.get());
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

	private void crop(CropBlock crop, int maxStage, IntegerProperty ageProperty) {
		int maxAge = crop.getMaxAge();
		getVariantBuilder(crop).forAllStates(state -> {
			int stage = Math.min(state.getValue(ageProperty) / (maxAge / maxStage), maxStage - 1);
			if (state.getValue(ageProperty) == maxAge) {
				stage = maxStage;
			}
			return ConfiguredModel.builder().modelFile(models().crop(name(crop) + "_stage" + stage, blockTexture(crop).withSuffix("_stage" + stage)).renderType(CUTOUT)).build();
		});
	}

	private ResourceLocation key(Block block) {
		return BuiltInRegistries.BLOCK.getKey(block);
	}

	private String name(Block block) {
		return key(block).getPath();
	}
}
