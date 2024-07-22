package ho.artisan.farm_away;

import ho.artisan.farm_away.common.registry.FABlocks;
import ho.artisan.farm_away.common.registry.FAItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FarmAway.ID)
public class FarmAway {
    public static final String ID = "farm_away";

    public FarmAway(IEventBus bus) {
        FABlocks.register(bus);
        FAItems.register(bus);
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}
