package ho.artisan.farm_away.common.gen.lang;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.registry.FABlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FAEnglishLanguageProvider extends LanguageProvider {
	public FAEnglishLanguageProvider(PackOutput output) {
		super(output, FarmAway.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add(FABlocks.STONE_FARMLAND.get(), "Stone Farmland");
		add(FABlocks.NETHERRACK_FARMLAND.get(), "Netherrack Farmland");
		add(FABlocks.END_STONE_FARMLAND.get(), "End Stone Farmland");
		add(FABlocks.GRANITE_FARMLAND.get(), "Granite Farmland");
		add(FABlocks.DIORITE_FARMLAND.get(), "Diorite Farmland");
		add(FABlocks.ANDESITE_FARMLAND.get(), "Andesite Farmland");
	}
}
