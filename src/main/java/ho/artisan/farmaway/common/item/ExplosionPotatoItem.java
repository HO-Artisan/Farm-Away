package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.entity.ExplosionPotatoEntity;
import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ExplosionPotatoItem extends ItemNameBlockItem implements ProjectileItem {
	public ExplosionPotatoItem(Properties properties) {
		super(FABlocks.EXPLOSION_POTATOES.get(), properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack stack = player.getItemInHand(player.getUsedItemHand());
		if (!level.isClientSide && player.isCrouching()) {
			level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
			ExplosionPotatoEntity potato = new ExplosionPotatoEntity(level, player);
			potato.setItem(stack);
			potato.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
			level.addFreshEntity(potato);

			player.awardStat(Stats.ITEM_USED.get(this));
			stack.consume(1, player);
		}

		return player.isCrouching() ? InteractionResultHolder.sidedSuccess(stack, level.isClientSide) : super.use(level, player, usedHand);
	}

	@Override
	public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
		ExplosionPotatoEntity potato = new ExplosionPotatoEntity(level, position.x(), position.y(), position.z());
		potato.setItem(this.getDefaultInstance());
		return potato;
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		tooltipComponents.add(Component.translatable(getDescriptionId() + ".tooltip").withStyle(ChatFormatting.YELLOW));
	}
}
