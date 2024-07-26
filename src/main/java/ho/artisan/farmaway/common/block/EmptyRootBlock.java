package ho.artisan.farmaway.common.block;

import com.mojang.serialization.MapCodec;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmptyRootBlock extends CropBlock {
	public static final MapCodec<EmptyRootBlock> CODEC = simpleCodec(EmptyRootBlock::new);

	public MapCodec<EmptyRootBlock> codec() {
		return CODEC;
	}

	public EmptyRootBlock(Properties properties) {
		super(properties);
	}

	@Override
	public int getMaxAge() {
		return 0;
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return false;
	}

	protected ItemLike getBaseSeedId() {
		return FAItems.EMPTY_ROOT.get();
	}

	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0);
	}
}
