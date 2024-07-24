package ho.artisan.farmaway.datagen.lang;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import ho.artisan.farmaway.common.registry.FAMobEffects;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FAChineseLanguageProvider extends LanguageProvider {
	public FAChineseLanguageProvider(PackOutput output) {
		super(output, FarmAway.MOD_ID, "zh_cn");
	}

	@Override
	protected void addTranslations() {
		add(FarmAway.descriptionId("itemGroup", "main"), "田园巫术");
		add(FAItems.ENHANCED_HOE.get(), "强化锄");
		add(FABlocks.STONE_FARMLAND.get(), "石耕地");
		add(FABlocks.NETHERRACK_FARMLAND.get(), "下界岩耕地");
		add(FABlocks.END_STONE_FARMLAND.get(), "末地石耕地");
		add(FABlocks.GRANITE_FARMLAND.get(), "花岗岩耕地");
		add(FABlocks.ANDESITE_FARMLAND.get(), "安山岩耕地");
		add(FABlocks.DIORITE_FARMLAND.get(), "闪长岩耕地");

		add(FABlocks.EXPLOSION_POTATOES.get(), "爆炎土豆");
		add(FABlocks.BLUES_CARROTS.get(), "蓝胡萝卜");
		add(FABlocks.STRONG_CARROTS.get(), "强力胡萝卜");

		add(FAItems.EXPLOSION_POTATO.get(), "爆炎土豆");
		add(FAItems.BLUES_CARROT.get(), "蓝胡萝卜");
		add(FAItems.STRONG_CARROT.get(), "强力胡萝卜");

		add(FAEntities.EXPLOSION_POTATO.get(), "爆炎土豆");

		add(Util.makeDescriptionId("effect", ResourceLocation.parse(FAMobEffects.BLUES.getRegisteredName())), "蓝");
	}
}
