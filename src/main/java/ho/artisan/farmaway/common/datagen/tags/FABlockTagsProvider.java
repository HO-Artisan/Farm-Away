package ho.artisan.farmaway.common.datagen.tags;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlockTags;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
			FABlocks.EXPLOSION_POTATO.get(),
			FABlocks.STRONG_CARROT.get()
		);
		tag(FABlockTags.SHADOW_CROPS).add(
			FABlocks.BLUE_CARROT.get()
		);
	}
}
