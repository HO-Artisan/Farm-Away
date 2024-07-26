package ho.artisan.farmaway.common.event;

import ho.artisan.farmaway.FarmAway;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FAMobEffects;
import ho.artisan.farmaway.common.util.RandomUtil;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Optional;

@EventBusSubscriber(modid = FarmAway.MOD_ID)
public class FAEvents {
	@SubscribeEvent
	private static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
		if (event.getEntity().hasEffect(FAMobEffects.BLUES)) {
			MobEffectInstance instance = event.getEntity().getEffect(FAMobEffects.BLUES);
			if (instance != null) {
				int amplifier = Math.min(instance.getAmplifier(), 6);
				if (event.getEntity().getRandom().nextInt(100) > 50 - amplifier * 5) {
					event.setAmount(0);
				} else {
					event.setAmount(event.getOriginalAmount() * 2);
				}
			}
		}
	}

	@SubscribeEvent
	private static void onBlockBreak(BlockEvent.BreakEvent event) {
		Optional<Block> block = RandomUtil.randomBlock();
		var block_state = event.getLevel().getBlockState(event.getPos());
		if (event.getPlayer().hasEffect(FAMobEffects.VOID)) {
			event.setCanceled(true);
		} else if (event.getPlayer().hasEffect(FAMobEffects.PHANTOM)) {
			if (!event.getLevel().getBlockState(event.getPos()).is(FABlocks.PHANTOM_DIRT)) {
				if (block_state.getBlock() instanceof CropBlock crop && crop != FABlocks.EMPTY_ROOT.get() && crop.getAge(block_state) == 0) {
					event.setCanceled(true);
					event.getLevel().setBlock(event.getPos(), FABlocks.EMPTY_ROOT.get().defaultBlockState(), 2);
				} else {
					if (RandomSource.create().nextInt(100) > 80) {
						event.setCanceled(true);
						block.ifPresent(value -> event.getLevel().setBlock(event.getPos(), value.defaultBlockState(), 2));
					} else {
						event.setCanceled(true);
						event.getLevel().setBlock(event.getPos(), FABlocks.PHANTOM_DIRT.get().defaultBlockState(), 2);
					}
				}
			} else {
				event.setCanceled(true);
			}
		}
	}
}
