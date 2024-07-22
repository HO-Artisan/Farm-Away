package ho.artisan.farm_away;

import ho.artisan.farm_away.common.registry.FABlocks;
import ho.artisan.farm_away.common.registry.FAItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(FarmAway.MOD_ID)
public class FarmAway {
	public static final String MOD_ID = "farm_away";

	public FarmAway(IEventBus bus, ModContainer container) {
		FABlocks.register(bus);
		FAItems.register(bus);
	}

	public static ResourceLocation getResourceLocation(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
