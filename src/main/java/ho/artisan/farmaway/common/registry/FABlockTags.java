package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class FABlockTags {
	public static final TagKey<Block> FARMLANDS = blockTag("farmlands");
	public static final TagKey<Block> TERRA_FARMLANDS = blockTag("farmlands/terra");
	public static final TagKey<Block> FLAME_FARMLANDS = blockTag("farmlands/flame");
	public static final TagKey<Block> SHADOW_FARMLANDS = blockTag("farmlands/shadow");
	public static final TagKey<Block> SCARLET_FARMLANDS = blockTag("farmlands/scarlet");
	public static final TagKey<Block> RAY_FARMLANDS = blockTag("farmlands/ray");
	public static final TagKey<Block> WIND_FARMLANDS = blockTag("farmlands/wind");

	public static final TagKey<Block> TERRA_CROPS = blockTag("crops/terra");
	public static final TagKey<Block> FLAME_CROPS = blockTag("crops/flame");
	public static final TagKey<Block> SHADOW_CROPS = blockTag("crops/shadow");
	public static final TagKey<Block> SCARLET_CROPS = blockTag("crops/scarlet");
	public static final TagKey<Block> RAY_CROPS = blockTag("crops/ray");
	public static final TagKey<Block> WIND_CROPS = blockTag("crops/wind");
	public static final TagKey<Block> PHANTOM_RANDOM_BLOCKS = blockTag("phantom_random_blocks");

	public static TagKey<Block> blockTag(String name) {
		return TagKey.create(Registries.BLOCK, FarmAway.getResourceLocation(name));
	}
}