package ho.artisan.farmaway.common.event;

import ho.artisan.farmaway.common.registry.FABlockTags;
import ho.artisan.farmaway.common.registry.FABlocks;
import ho.artisan.farmaway.common.registry.FAMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Optional;

public class FAEvents {
	public static void registerEvents(IEventBus forgeEventbus) {
		forgeEventbus.addListener(FAEvents::onLivingIncomingDamage);
		forgeEventbus.addListener(FAEvents::onBlockBreak);
	}

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

	private static void onBlockBreak(BlockEvent.BreakEvent event) {
		Optional<Block> block = BuiltInRegistries.BLOCK.getRandomElementOf(FABlockTags.PHANTOM_RANDOM_BLOCKS, RandomSource.create()).map(Holder::value);

		BlockState state = event.getLevel().getBlockState(event.getPos());
		if (event.getPlayer().hasEffect(FAMobEffects.VOID)) {
			event.setCanceled(true);
		} else if (event.getPlayer().hasEffect(FAMobEffects.PHANTOM)) {
			if (!event.getLevel().getBlockState(event.getPos()).is(FABlocks.PHANTOM_DIRT)) {
				if (state.getBlock() instanceof CropBlock crop && crop != FABlocks.EMPTY_ROOT.get() && crop.getAge(state) == 0) {
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
