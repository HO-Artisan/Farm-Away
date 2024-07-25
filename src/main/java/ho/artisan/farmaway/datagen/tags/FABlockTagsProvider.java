package ho.artisan.farmaway.datagen.tags;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlockTags;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class FABlockTagsProvider extends BlockTagsProvider {
	public FABlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper helper) {
		super(output, future, FarmAway.MOD_ID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
			FABlocks.STONE_FARMLAND.get(),
			FABlocks.NETHERRACK_FARMLAND.get(),
			FABlocks.END_STONE_FARMLAND.get(),
			FABlocks.GRANITE_FARMLAND.get(),
			FABlocks.ANDESITE_FARMLAND.get(),
			FABlocks.DIORITE_FARMLAND.get()
		);
		tag(FABlockTags.FLAME_CROPS).add(
			FABlocks.EXPLOSION_POTATOES.get(),
			FABlocks.STRONG_CARROTS.get()
		);
		tag(FABlockTags.SHADOW_CROPS).add(
			FABlocks.BLUES_CARROTS.get(),
			FABlocks.PHANTOM_POTATOES.get(),
			FABlocks.PHANTOM_BEETROOTS.get()
		);
		tag(FABlockTags.WIND_CROPS).add(
			FABlocks.MELON_ROCKET.get()
		);
		tag(FABlockTags.SCARLET_CROPS).add(
			FABlocks.ROSE_POTATOES.get()
		);
		tag(FABlockTags.RAY_CROPS).add(
			FABlocks.GERBERA_POTATOES.get()
		);
		tag(FABlockTags.TERRA_FARMLANDS).add(FABlocks.STONE_FARMLAND.get());
		tag(FABlockTags.FLAME_FARMLANDS).add(FABlocks.NETHERRACK_FARMLAND.get());
		tag(FABlockTags.SHADOW_FARMLANDS).add(FABlocks.END_STONE_FARMLAND.get());
		tag(FABlockTags.SCARLET_FARMLANDS).add(FABlocks.GRANITE_FARMLAND.get());
		tag(FABlockTags.RAY_FARMLANDS).add(FABlocks.ANDESITE_FARMLAND.get());
		tag(FABlockTags.WIND_FARMLANDS).add(FABlocks.DIORITE_FARMLAND.get());
		tag(FABlockTags.PHANTOM_RANDOM_BLOCKS).add(
			Blocks.AMETHYST_CLUSTER,
			Blocks.DIAMOND_BLOCK,
			Blocks.GOLD_BLOCK,
			Blocks.OBSIDIAN,
			Blocks.OBSERVER,
			Blocks.WHITE_WOOL,
			Blocks.LAVA,
			Blocks.FARMLAND,
			Blocks.DAMAGED_ANVIL,
			Blocks.TNT,
			Blocks.ANCIENT_DEBRIS
		);
		tag(FABlockTags.FARMLANDS).addTags(FABlockTags.TERRA_FARMLANDS, FABlockTags.FLAME_FARMLANDS, FABlockTags.SHADOW_FARMLANDS, FABlockTags.SCARLET_FARMLANDS, FABlockTags.RAY_FARMLANDS, FABlockTags.WIND_FARMLANDS);
	}
}
