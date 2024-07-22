package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FATags {
    public static TagKey<Block> TERRA_CROP = create("terra_crop");
    public static TagKey<Block> FLAME_CROP = create("flame_crop");
    public static TagKey<Block> SHADOW_CROP = create("shadow_crop");
    public static TagKey<Block> SCARLET_CROP = create("scarlet_crop");
    public static TagKey<Block> RAY_CROP = create("ray_crop");
    public static TagKey<Block> WIND_CROP = create("wind_crop");

    public static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, FarmAway.getResourceLocation(name));
    }
}
