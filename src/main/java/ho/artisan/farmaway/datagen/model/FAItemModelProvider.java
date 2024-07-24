package ho.artisan.farmaway.datagen.model;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FAItemModelProvider extends ItemModelProvider {
	public FAItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, FarmAway.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		inventoryHandheld(FAItems.ENHANCED_HOE.get());
		block(FAItems.STONE_FARMLAND.get());
		block(FAItems.NETHERRACK_FARMLAND.get());
		block(FAItems.END_STONE_FARMLAND.get());
		block(FAItems.GRANITE_FARMLAND.get());
		block(FAItems.DIORITE_FARMLAND.get());
		block(FAItems.ANDESITE_FARMLAND.get());
		block(FAItems.PHANTOM_DIRT.get());
		basicItem(FAItems.EXPLOSION_POTATO.get());
		basicItem(FAItems.BLUES_CARROT.get());
		basicItem(FAItems.MELON_ROCKET.get());
		basicItem(FAItems.MELON_ROCKET_SEED.get());
		basicItem(FAItems.PHANTOM_POTATO.get());
		basicItem(FAItems.PHANTOM_BEETROOT.get());
		handheld(FAItems.STRONG_CARROT.get());
	}

	private void block(Item item) {
		withExistingParent(name(item), modLoc(ModelProvider.BLOCK_FOLDER + "/" + name(item)));
	}

	private void handheld(Item item) {
		handheld(item, itemTexture(item));
	}

	private void handheld(Item item, ResourceLocation texture) {
		getBuilder(item.toString())
			.parent(new ModelFile.UncheckedModelFile("item/handheld"))
			.texture("layer0", texture);
	}

	private void inventoryHandheld(Item item) {
		getBuilder(item.toString() + "_inventory")
			.parent(new ModelFile.UncheckedModelFile("item/handheld"))
			.texture("layer0", itemTexture(item) + "_inventory");
	}

	public ResourceLocation itemTexture(Item item) {
		ResourceLocation name = key(item);
		return texture(name, ModelProvider.ITEM_FOLDER);
	}

	public ResourceLocation texture(ResourceLocation key, String prefix) {
		return ResourceLocation.fromNamespaceAndPath(key.getNamespace(), prefix + "/" + key.getPath());
	}

	private ResourceLocation key(Item item) {
		return BuiltInRegistries.ITEM.getKey(item);
	}

	private String name(Item item) {
		return key(item).getPath();
	}
}
