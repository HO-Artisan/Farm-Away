package ho.artisan.farmaway.common.data;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

public class FARegistries {
	public static final ResourceKey<Registry<Ritual>> RITUAL = ResourceKey.createRegistryKey(FarmAway.getResourceLocation("ritual"));
	public static void bring() {
		IEventBus bus = ModList.get().getModContainerById(RITUAL.location().getNamespace()).get().getEventBus();
		bus.addListener(DataPackRegistryEvent.NewRegistry.class, (event) -> event.dataPackRegistry(RITUAL, Ritual.CODEC, Ritual.CODEC));
	}
}
