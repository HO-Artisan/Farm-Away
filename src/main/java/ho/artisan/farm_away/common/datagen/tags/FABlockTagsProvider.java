package ho.artisan.farm_away.common.datagen.tags;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.registry.FABlocks;
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
			FABlocks.DIORITE_FARMLAND.get(),
			FABlocks.ANDESITE_FARMLAND.get()
		);
	}
}
