package ho.artisan.farmaway.datagen;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.datagen.lang.FAChineseLanguageProvider;
import ho.artisan.farmaway.datagen.lang.FAEnglishLanguageProvider;
import ho.artisan.farmaway.datagen.loot.FALootProvider;
import ho.artisan.farmaway.datagen.model.FABlockStateProvider;
import ho.artisan.farmaway.datagen.model.FAItemModelProvider;
import ho.artisan.farmaway.datagen.tags.FABlockTagsProvider;
import ho.artisan.farmaway.datagen.tags.FAItemTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = FarmAway.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	@SubscribeEvent
	public static void onGatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeClient(), new FAEnglishLanguageProvider(output));
		generator.addProvider(event.includeClient(), new FAChineseLanguageProvider(output));

		generator.addProvider(event.includeClient(), new FABlockStateProvider(output, helper));
		generator.addProvider(event.includeClient(), new FAItemModelProvider(output, helper));

		FABlockTagsProvider blockTags = new FABlockTagsProvider(output, lookupProvider, helper);
		generator.addProvider(event.includeServer(), blockTags);
		generator.addProvider(event.includeServer(), new FAItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), helper));

		generator.addProvider(event.includeServer(), new FALootProvider(output, lookupProvider));
	}
}
