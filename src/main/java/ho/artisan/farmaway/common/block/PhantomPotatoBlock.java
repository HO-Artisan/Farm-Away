package ho.artisan.farmaway.common.block;

import com.mojang.serialization.MapCodec;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PhantomPotatoBlock extends FACropBlock{
	public static final MapCodec<PhantomPotatoBlock> CODEC = simpleCodec(PhantomPotatoBlock::new);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0), Block.box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0)};

	public MapCodec<PhantomPotatoBlock> codec() {
		return CODEC;
	}

	public PhantomPotatoBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public int getMaxAge() {
		return 6;
	}

	protected ItemLike getBaseSeedId() {
		return FAItems.EXPLOSION_POTATO.get();
	}

	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}
}
