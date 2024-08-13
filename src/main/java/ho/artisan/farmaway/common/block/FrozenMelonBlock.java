package ho.artisan.farmaway.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class FrozenMelonBlock extends Block {
	public FrozenMelonBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		List<ServerPlayer> players = level.getPlayers(player -> player.position().distanceTo(pos.getCenter()) < 2.4F);
		players.forEach(player -> player.setIsInPowderSnow(true));
	}
}
