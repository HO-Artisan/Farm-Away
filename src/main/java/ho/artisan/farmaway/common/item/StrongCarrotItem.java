package ho.artisan.farmaway.common.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

public class StrongCarrotItem extends ItemNameBlockItem {
	public StrongCarrotItem(Block block, Properties properties) {
		super(block, properties.durability(300).attributes(modifiers()).component(DataComponents.TOOL, createToolProperties()));
	}

	private static Tool createToolProperties() {
		return new Tool(
			List.of(
				Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F),
				Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)
			),
			1.0F,
			2
		);
	}

	private static ItemAttributeModifiers modifiers() {
		return ItemAttributeModifiers.builder().add(
			Attributes.ATTACK_DAMAGE,
			new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 2.0d, AttributeModifier.Operation.ADD_VALUE),
			EquipmentSlotGroup.MAINHAND
		).add(
			Attributes.ATTACK_SPEED,
			new AttributeModifier(BASE_ATTACK_SPEED_ID, 5.0d, AttributeModifier.Operation.ADD_VALUE),
			EquipmentSlotGroup.MAINHAND
		).build();
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		if (context.getPlayer() == null || !context.getPlayer().getItemInHand(context.getHand()).isDamaged()) {
			return super.useOn(context);
		}
		return InteractionResult.PASS;
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		return true;
	}

	@Override
	public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
		return ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(itemAbility);
	}
}
