package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.entity.ExplosionPotatoEntity;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class ExplosionPotatoItem extends BlockItem implements ProjectileItem {
	public ExplosionPotatoItem(Properties properties) {
		super(FABlocks.EXPLOSION_POTATO.get(), properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack itemstack = player.getItemInHand(player.getUsedItemHand());
		level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		if (!level.isClientSide) {
			ExplosionPotatoEntity potato = new ExplosionPotatoEntity(level, player);
			potato.setItem(itemstack);
			potato.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(potato);
		}

		player.awardStat(Stats.ITEM_USED.get(this));
		itemstack.consume(1, player);
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}

	@Override
	public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
		ExplosionPotatoEntity potato = new ExplosionPotatoEntity(level, position.x(), position.y(), position.z());
		potato.setItem(this.getDefaultInstance());
		return potato;
	}
}
