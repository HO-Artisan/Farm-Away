package ho.artisan.farmaway.common.data;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class FARegistries {
	public static final ResourceKey<Registry<Ritual>> RITUAL = ResourceKey.createRegistryKey(FarmAway.getResourceLocation("ritual"));
}
