package ho.artisan.farmaway.datagen.tags;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAItemTags;
import ho.artisan.farmaway.common.registry.FAItems;
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
		tag(ItemTags.SWORDS).add(
			FAItems.STRONG_CARROT.get()
		);
		tag(ItemTags.HOES).add(
			FAItems.ENHANCED_HOE.get()
		);
		tag(FAItemTags.FLAME_SEEDS).add(
			FAItems.EXPLOSION_POTATO.get(),
			FAItems.STRONG_CARROT.get()
		);
		tag(FAItemTags.SHADOW_SEEDS).add(
			FAItems.BLUES_CARROT.get()
		);
	}
}
