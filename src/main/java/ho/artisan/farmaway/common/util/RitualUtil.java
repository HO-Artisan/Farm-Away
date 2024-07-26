package ho.artisan.farmaway.common.util;

import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class RitualUtil {
	public static void start(Level level, BlockPos pos, ResourceKey<Ritual> key) {
		var r = Ritual.of(level.registryAccess(), key);
		if (r.isPresent()) {
			var ritual = r.get();
			if (level.getBlockState(pos).getBlock() == ritual.centre()) {
				level.setBlock(pos.below(), ritual.baseOut().value().defaultBlockState(), 2);
				level.setBlock(pos, ritual.centreOut().value().defaultBlockState(), 2);
			}
		}
	}
}
