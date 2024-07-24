package ho.artisan.farmaway.common.registry;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.*;

public class FACropTransformationRegistry {
	private static final Map<TagKey<Block>, Map<Block, List<Block>>> TRANSFORMATIONS = new HashMap<>();

	public static void register(TagKey<Block> farmland, Block crop, Block transformed) {
		if (!TRANSFORMATIONS.containsKey(farmland)) {
			TRANSFORMATIONS.put(farmland, new HashMap<>());
		}
		Map<Block, List<Block>> map = TRANSFORMATIONS.get(farmland);
		if (!map.containsKey(crop)) {
			map.put(crop, new ArrayList<>());
		}
		map.get(crop).add(transformed);
	}

	public static Optional<List<Block>> getTransformed(Block farmland, Block crop) {
		for (TagKey<Block> tag : TRANSFORMATIONS.keySet()) {
			if (farmland.builtInRegistryHolder().is(tag)) {
				return Optional.ofNullable(TRANSFORMATIONS.get(tag).get(crop));
			}
		}
		return Optional.empty();
	}
}
