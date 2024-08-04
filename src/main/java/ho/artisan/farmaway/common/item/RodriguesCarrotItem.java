package ho.artisan.farmaway.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RodriguesCarrotItem extends Item {
	public RodriguesCarrotItem(Properties properties) {
		super(properties);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.SPEAR;
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
		if (livingEntity instanceof Player player) {
			player.awardStat(Stats.ITEM_USED.get(this));
			float yRot = player.getYRot();
			float xRot = player.getXRot();
			float f2 = -Mth.sin(yRot * 0.017453292F) * Mth.cos(xRot * 0.017453292F);
			float f3 = -Mth.sin(xRot * 0.017453292F);
			float f4 = Mth.cos(yRot * 0.017453292F) * Mth.cos(xRot * 0.017453292F);
			float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
			f2 *= 3.0f / f5;
			f3 *= 3.0f / f5;
			f4 *= 3.0f / f5;
			player.push(f2, f3, f4);
			player.startAutoSpinAttack(10, 8.0F, stack);
			if (player.onGround()) {
				player.move(MoverType.SELF, new Vec3(0.0, 2.233, 0.0));
			}

			level.playSound(null, player, SoundEvents.TRIDENT_RIPTIDE_3.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
			player.awardStat(Stats.ITEM_USED.get(this));
			stack.consume(1, player);
		}
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		player.startUsingItem(hand);
		return InteractionResultHolder.consume(player.getItemInHand(hand));
	}
}
