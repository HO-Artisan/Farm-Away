package ho.artisan.farmaway.common.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FALootProvider extends LootTableProvider {
	public FALootProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
		super(packOutput, Set.of(), List.of(
			new SubProviderEntry(FABlockLootSubProvider::new, LootContextParamSets.BLOCK)
		), provider);
	}
}