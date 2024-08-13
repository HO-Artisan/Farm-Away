package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.entity.StonatoEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class StonatoItem extends ItemNameBlockItem implements ProjectileItem {
	public StonatoItem(Block block, Properties properties) {
		super(block, properties.attributes(modifiers()));
	}

	private static ItemAttributeModifiers modifiers() {
		return ItemAttributeModifiers.builder().add(
			Attributes.ATTACK_DAMAGE,
			new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 1.0d, AttributeModifier.Operation.ADD_VALUE),
			EquipmentSlotGroup.MAINHAND
		).add(
			Attributes.ATTACK_SPEED,
			new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.4d, AttributeModifier.Operation.ADD_VALUE),
			EquipmentSlotGroup.MAINHAND
		).build();
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack stack = player.getItemInHand(player.getUsedItemHand());
		if (!level.isClientSide && player.isCrouching()) {
			level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
			StonatoEntity potato = new StonatoEntity(level, player);
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
		return new StonatoEntity(level, position.x(), position.y(), position.z());
	}
}
