package ho.artisan.farm_away;

import ho.artisan.farm_away.common.init.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod("farm_away")
public class FarmAway {
    public FarmAway(IEventBus bus) {
        ModBlocks.register(bus);
    }
}
