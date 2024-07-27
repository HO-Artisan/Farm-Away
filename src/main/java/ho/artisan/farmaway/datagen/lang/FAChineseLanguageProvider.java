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
		add(FAItems.ENHANCED_HOE.get().getDescriptionId() + ".tooltip", "可开垦：");
		add(FABlocks.STONE_FARMLAND.get(), "石耕地");
		add(FABlocks.NETHERRACK_FARMLAND.get(), "下界岩耕地");
		add(FABlocks.END_STONE_FARMLAND.get(), "末地石耕地");
		add(FABlocks.GRANITE_FARMLAND.get(), "花岗岩耕地");
		add(FABlocks.ANDESITE_FARMLAND.get(), "安山岩耕地");
		add(FABlocks.DIORITE_FARMLAND.get(), "闪长岩耕地");
		add(FABlocks.PHANTOM_DIRT.get(), "幻影泥土");

		add(FABlocks.EXPLOSION_POTATOES.get(), "爆炎土豆");
		add(FABlocks.BLUES_CARROTS.get(), "忧郁胡萝卜");
		add(FABlocks.STRONG_CARROTS.get(), "强力胡萝卜");
		add(FABlocks.PHANTOM_POTATOES.get(), "幻影土豆");
		add(FABlocks.PHANTOM_BEETROOTS.get(), "幻影甜菜根");
		add(FABlocks.MELON_ROCKET.get(), "西瓜火箭");
		add(FABlocks.ROSE_POTATOES.get(), "玫瑰土豆");
		add(FABlocks.SOFT_POTATOES.get(), "柔软土豆");

		add(FAItems.EXPLOSION_POTATO.get(), "爆炎土豆");
		add(FAItems.EXPLOSION_POTATO.get().getDescriptionId() + ".tooltip", "潜行时：可投掷");
		add(FAItems.BLUES_CARROT.get(), "忧郁胡萝卜");
		add(FAItems.BLUES_CARROT.get().getDescriptionId() + ".tooltip", "食用后：受到伤害可能取消或翻倍");
		add(FAItems.STRONG_CARROT.get(), "强力胡萝卜");
		add(FAItems.PHANTOM_POTATO.get(), "幻影土豆");
		add(FAItems.PHANTOM_BEETROOT.get(), "幻影甜菜根");
		add(FAItems.PHANTOM_BEETROOT.get().getDescriptionId() + ".tooltip", "潜行时：可投掷");
		add(FAItems.MELON_ROCKET.get(), "西瓜火箭");
		add(FAItems.MELON_ROCKET.get().getDescriptionId() + ".tooltip", "潜行时：可发射");
		add(FAItems.MELON_ROCKET_SEED.get(), "西瓜火箭种子");
		add(FAItems.ROSE_POTATO.get(), "玫瑰土豆");
		add(FAItems.ROSE_POTATO.get().getDescriptionId() + ".tooltip", "可加速作物生长");
		add(FAItems.SOFT_POTATO.get(), "柔软土豆");

		add(FAEntities.EXPLOSION_POTATO.get(), "爆炎土豆");
		add(FAEntities.PHANTOM_BEETROOT.get(), "幻影甜菜根");
		add(FAEntities.MELON_ROCKET.get(), "西瓜火箭");

		add(Util.makeDescriptionId("effect", ResourceLocation.parse(FAMobEffects.BLUES.getRegisteredName())), "忧郁");
		add(Util.makeDescriptionId("effect", ResourceLocation.parse(FAMobEffects.PHANTOM.getRegisteredName())), "幻象");
	}
}
