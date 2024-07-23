package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FAItemTags {
	public static TagKey<Item> TERRA_SEEDS = create("terra_seeds");
	public static TagKey<Item> FLAME_SEEDS = create("flame_seeds");
	public static TagKey<Item> SHADOW_SEEDS = create("shadow_seeds");
	public static TagKey<Item> SCARLET_SEEDS = create("scarlet_seeds");
	public static TagKey<Item> RAY_SEEDS = create("ray_seeds");
	public static TagKey<Item> WIND_SEEDS = create("wind_seeds");

	public static TagKey<Item> create(String name) {
		return TagKey.create(Registries.ITEM, FarmAway.getResourceLocation(name));
	}
}
