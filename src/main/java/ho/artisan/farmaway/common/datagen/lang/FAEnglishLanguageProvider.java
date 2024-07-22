package ho.artisan.farmaway.common.datagen.lang;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FAEnglishLanguageProvider extends LanguageProvider {
	public FAEnglishLanguageProvider(PackOutput output) {
		super(output, FarmAway.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add(FarmAway.descriptionId("itemGroup", "main"), "Farm Away");
		add(FAItems.ENHANCED_HOE.get(), "Enhanced Hoe");
		add(FABlocks.STONE_FARMLAND.get(), "Stone Farmland");
		add(FABlocks.NETHERRACK_FARMLAND.get(), "Netherrack Farmland");
		add(FABlocks.END_STONE_FARMLAND.get(), "End Stone Farmland");
		add(FABlocks.GRANITE_FARMLAND.get(), "Granite Farmland");
		add(FABlocks.ANDESITE_FARMLAND.get(), "Andesite Farmland");
		add(FABlocks.DIORITE_FARMLAND.get(), "Diorite Farmland");
	}
}