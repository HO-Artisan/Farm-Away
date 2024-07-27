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

public class FAEnglishLanguageProvider extends LanguageProvider {
	public FAEnglishLanguageProvider(PackOutput output) {
		super(output, FarmAway.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add(FarmAway.descriptionId("itemGroup", "main"), "Farm Away");
		add(FAItems.ENHANCED_HOE.get(), "Enhanced Hoe");
		add(FAItems.ENHANCED_HOE.get().getDescriptionId() + ".tooltip", "Able to Till:");
		add(FABlocks.STONE_FARMLAND.get(), "Stone Farmland");
		add(FABlocks.NETHERRACK_FARMLAND.get(), "Netherrack Farmland");
		add(FABlocks.END_STONE_FARMLAND.get(), "End Stone Farmland");
		add(FABlocks.GRANITE_FARMLAND.get(), "Granite Farmland");
		add(FABlocks.ANDESITE_FARMLAND.get(), "Andesite Farmland");
		add(FABlocks.DIORITE_FARMLAND.get(), "Diorite Farmland");
		add(FABlocks.PHANTOM_DIRT.get(), "Phantom Dirt");
		add(FABlocks.SOLID_CLOUD.get(), "Solid Cloud");
		add(FABlocks.EMPTY_ROOT.get(), "Empty Root");

		add(FABlocks.EXPLOSION_POTATOES.get(), "Explosion Potatoes");
		add(FABlocks.GERBERA_POTATOES.get(), "Gerbera Potatoes");
		add(FABlocks.BLUES_CARROTS.get(), "Blues Carrots");
		add(FABlocks.STRONG_CARROTS.get(), "Strong Carrots");
		add(FABlocks.PHANTOM_POTATOES.get(), "Phantom Potatoes");
		add(FABlocks.PHANTOM_BEETROOTS.get(), "Phantom Beetroots");
		add(FABlocks.MELON_ROCKET.get(), "Melon Rocket");
		add(FABlocks.ROSE_POTATOES.get(), "Rose Potatoes");
		add(FABlocks.SOFT_POTATOES.get(), "Soft Potatoes");

		add(FAItems.EXPLOSION_POTATO.get(), "Explosion Potato");
		add(FAItems.EXPLOSION_POTATO.get().getDescriptionId() + ".tooltip", "When Crouching: Can be thrown");
		add(FAItems.GERBERA_POTATO.get(), "Gerbera Potato");
		add(FAItems.BLUES_CARROT.get(), "Blues Carrot");
		add(FAItems.BLUES_CARROT.get().getDescriptionId() + ".tooltip", "When Eaten: Damage taken may be canceled or doubled");
		add(FAItems.STRONG_CARROT.get(), "Strong Carrot");
		add(FAItems.PHANTOM_POTATO.get(), "Phantom Potato");
		add(FAItems.PHANTOM_BEETROOT.get(), "Phantom Beetroot");
		add(FAItems.PHANTOM_BEETROOT.get().getDescriptionId() + ".tooltip", "When Crouching: Can be thrown");
		add(FAItems.MELON_ROCKET.get(), "Melon Rocket");
		add(FAItems.MELON_ROCKET.get().getDescriptionId() + ".tooltip", "When Crouching: Can be launched");
		add(FAItems.MELON_ROCKET_SEED.get(), "Melon Rocket Seed");
		add(FAItems.ROSE_POTATO.get(), "Rose Potato");
		add(FAItems.ROSE_POTATO.get().getDescriptionId() + ".tooltip", "Can accelerate crop growth");
		add(FAItems.SOFT_POTATO.get(), "Soft Potato");

		add(FAEntities.EXPLOSION_POTATO.get(), "Explosion Potato");
		add(FAEntities.PHANTOM_BEETROOT.get(), "Phantom Beetroot");
		add(FAEntities.MELON_ROCKET.get(), "Melon Rocket");

		add(Util.makeDescriptionId("effect", ResourceLocation.parse(FAMobEffects.BLUES.getRegisteredName())), "Blues");
		add(Util.makeDescriptionId("effect", ResourceLocation.parse(FAMobEffects.PHANTOM.getRegisteredName())), "Phantom");
	}
}
