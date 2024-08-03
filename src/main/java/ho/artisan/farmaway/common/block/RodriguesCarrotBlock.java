package ho.artisan.farmaway.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RodriguesCarrotBlock extends FACropBlock {
	public static final MapCodec<RodriguesCarrotBlock> CODEC = simpleCodec(RodriguesCarrotBlock::new);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{ Block.box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0) };

	public MapCodec<RodriguesCarrotBlock> codec() {
		return CODEC;
	}
	public RodriguesCarrotBlock(Properties properties) {
		super(properties);
	}

	@Override
	public int getMaxAge() {
		return 0;
	}

	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}
}
