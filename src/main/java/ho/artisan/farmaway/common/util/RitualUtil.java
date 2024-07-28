package ho.artisan.farmaway.common.util;

import ho.artisan.farmaway.common.ritual.Ritual;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.Blocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RitualUtil {
	public static void start(Level level, BlockPos pos, ResourceKey<Ritual> key) {
		var r = Ritual.of(level.registryAccess(), key);
		if (r.isPresent()) {
			var ritual = r.get();
			Set<Block> list = new HashSet<>();
			Set<Block> base = new HashSet<>();
            list.addAll(level.getBlockStates(AABB.ofSize(pos.below().getCenter(), 2.0, 0.0, 2.0)).map(BlockBehaviour.BlockStateBase::getBlock).toList());
            base.addAll(ritual.ritualBase().stream().map(Holder::value).toList());
			if (level.getBlockState(pos).getBlock() == ritual.center().value() && list.equals(base)) {
				level.setBlock(pos.below(), ritual.baseOut().value().defaultBlockState(), 2);
				level.setBlock(pos, ritual.centerOut().value().defaultBlockState(), 2);
			}
		}
	}
}
