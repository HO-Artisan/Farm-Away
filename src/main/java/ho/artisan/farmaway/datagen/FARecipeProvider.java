package ho.artisan.farmaway.datagen;

import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class FARecipeProvider extends RecipeProvider {
	public FARecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, FAItems.ENHANCED_HOE.get())
			.requires(Items.NETHERITE_HOE)
			.requires(Items.NETHER_STAR)
			.unlockedBy("has_netherite_hoe", has(Items.NETHERITE_HOE))
			.unlockedBy("has_nether_star", has(Items.NETHER_STAR))
			.save(recipeOutput);
	}
}
