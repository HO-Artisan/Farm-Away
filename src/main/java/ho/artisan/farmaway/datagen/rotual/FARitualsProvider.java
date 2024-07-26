package ho.artisan.farmaway.datagen.rotual;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.data.FARegistries;
import ho.artisan.farmaway.common.data.FARituals;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FARitualsProvider extends DatapackBuiltinEntriesProvider {
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(FARegistries.RITUAL, FARituals::init);

	public FARitualsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(FarmAway.MOD_ID));
	}
}
