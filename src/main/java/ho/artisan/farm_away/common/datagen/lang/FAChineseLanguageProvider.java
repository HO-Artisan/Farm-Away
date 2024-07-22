package ho.artisan.farm_away.common.datagen.lang;

import ho.artisan.farm_away.FarmAway;
import ho.artisan.farm_away.common.registry.FABlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FAChineseLanguageProvider extends LanguageProvider {
	public FAChineseLanguageProvider(PackOutput output) {
		super(output, FarmAway.MOD_ID, "zh_cn");
	}

	@Override
	protected void addTranslations() {
		add(FarmAway.descriptionId("itemGroup", "main"), "田园巫术");
		add(FABlocks.STONE_FARMLAND.get(), "石耕地");
		add(FABlocks.NETHERRACK_FARMLAND.get(), "下界岩耕地");
		add(FABlocks.END_STONE_FARMLAND.get(), "末地石耕地");
		add(FABlocks.GRANITE_FARMLAND.get(), "花岗岩耕地");
		add(FABlocks.DIORITE_FARMLAND.get(), "闪长岩耕地");
		add(FABlocks.ANDESITE_FARMLAND.get(), "安山岩耕地");
	}
}
