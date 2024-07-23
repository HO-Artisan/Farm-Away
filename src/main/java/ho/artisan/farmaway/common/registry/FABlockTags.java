package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FABlockTags {
	public static TagKey<Block> FARMLANDS = blockTag("farmlands");
	public static TagKey<Block> TERRA_FARMLANDS = blockTag("farmlands/terra");
	public static TagKey<Block> FLAME_FARMLANDS = blockTag("farmlands/flame");
	public static TagKey<Block> SHADOW_FARMLANDS = blockTag("farmlands/shadow");
	public static TagKey<Block> SCARLET_FARMLANDS = blockTag("farmlands/scarlet");
	public static TagKey<Block> RAY_FARMLANDS = blockTag("farmlands/ray");
	public static TagKey<Block> WIND_FARMLANDS = blockTag("farmlands/wind");

    public static TagKey<Block> TERRA_CROPS = blockTag("crops/terra");
    public static TagKey<Block> FLAME_CROPS = blockTag("crops/flame");
    public static TagKey<Block> SHADOW_CROPS = blockTag("crops/shadow");
    public static TagKey<Block> SCARLET_CROPS = blockTag("crops/scarlet");
    public static TagKey<Block> RAY_CROPS = blockTag("crops/ray");
    public static TagKey<Block> WIND_CROPS = blockTag("crops/wind");

    public static TagKey<Block> blockTag(String name) {
		return TagKey.create(Registries.BLOCK, FarmAway.getResourceLocation(name));
	}
}