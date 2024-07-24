package ho.artisan.farmaway.common.util;

import ho.artisan.farmaway.common.registry.FABlockTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class RandomUtil {
	public static Optional<Block> randomBlock() {
		Optional<Holder<Block>> block = BuiltInRegistries.BLOCK.getRandomElementOf(FABlockTags.PHANTOM_RANDOM_BLOCKS, RandomSource.create());
		return block.map(Holder::value);
	}
}
