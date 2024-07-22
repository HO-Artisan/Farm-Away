package ho.artisan.farm_away.common.gen.tags;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.registry.FAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class FAItemTagsProvider extends ItemTagsProvider {
	public FAItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> provider, ExistingFileHelper helper) {
		super(output, future, provider, FarmAway.MOD_ID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {
		tag(ItemTags.HOES).add(
			FAItems.ENHANCED_HOE.get()
		);
	}
}
