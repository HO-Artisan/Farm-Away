package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FABlockTags {
    public static TagKey<Block> TERRA_CROPS = create("terra_crops");
    public static TagKey<Block> FLAME_CROPS = create("flame_crops");
    public static TagKey<Block> SHADOW_CROPS = create("shadow_crops");
    public static TagKey<Block> SCARLET_CROPS = create("scarlet_crops");
    public static TagKey<Block> RAY_CROPS = create("ray_crops");
    public static TagKey<Block> WIND_CROPS = create("wind_crops");
    public static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, FarmAway.getResourceLocation(name));
    }
}
