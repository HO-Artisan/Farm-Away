package ho.artisan.farmaway.common.mixin;

import ho.artisan.farmaway.common.block.FarmlandBlock;
import ho.artisan.farmaway.common.registry.FACropTransformationRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public abstract class CropBlockMixin {
	@Inject(method = "mayPlaceOn", at = @At("RETURN"), cancellable = true)
	public void mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (state.getBlock() instanceof FarmlandBlock) {
			cir.setReturnValue(true);
		}
	}

	@Inject(method = "randomTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", shift = At.Shift.AFTER))
	public void randomTickGrowCrops(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci) {
		FACropTransformationRegistry.getTransformed(level.getBlockState(pos.below()).getBlock(), (CropBlock) (Object) this).ifPresent(l -> {
			Block transformed = l.get(random.nextInt(l.size()));
			level.setBlock(pos, transformed.defaultBlockState(), 2);
		});
	}

	@Inject(method = "growCrops", at = @At("TAIL"))
	public void growCrops(Level level, BlockPos pos, BlockState state, CallbackInfo ci) {
		FACropTransformationRegistry.getTransformed(level.getBlockState(pos.below()).getBlock(), (CropBlock) (Object) this).ifPresent(l -> {
			Block transformed = l.get(level.getRandom().nextInt(l.size()));
			level.setBlock(pos, transformed.defaultBlockState(), 2);
		});
	}
}
