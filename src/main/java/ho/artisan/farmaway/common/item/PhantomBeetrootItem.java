package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.entity.PhantomBeetrootEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class PhantomBeetrootItem extends ItemNameBlockItem implements ProjectileItem {
	public PhantomBeetrootItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack stack = player.getItemInHand(player.getUsedItemHand());
		if (!level.isClientSide && player.isCrouching()) {
			level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
			PhantomBeetrootEntity beetroot = new PhantomBeetrootEntity(level, player);
			beetroot.setItem(stack);
			beetroot.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(beetroot);

			player.awardStat(Stats.ITEM_USED.get(this));
			stack.consume(1, player);
		}

		return player.isCrouching() ? InteractionResultHolder.sidedSuccess(stack, level.isClientSide) : super.use(level, player, usedHand);
	}

	@Override
	public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
		return new PhantomBeetrootEntity(level, pos.x(), pos.y(), pos.z());
	}
}
