package ho.artisan.farmaway.common.registry;

import ho.artisan.farmaway.FarmAway;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class FAItemTags {
	public static TagKey<Item> TERRA_SEEDS = create("seeds/terra");
	public static TagKey<Item> FLAME_SEEDS = create("seeds/flame");
	public static TagKey<Item> SHADOW_SEEDS = create("seeds/shadow");
	public static TagKey<Item> SCARLET_SEEDS = create("seeds/scarlet");
	public static TagKey<Item> RAY_SEEDS = create("seeds/ray");
	public static TagKey<Item> WIND_SEEDS = create("seeds/wind");

	public static TagKey<Item> create(String name) {
		return TagKey.create(Registries.ITEM, FarmAway.getResourceLocation(name));
	}
}
