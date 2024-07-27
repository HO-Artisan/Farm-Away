package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;

import java.util.List;

public class RosePotatoItem extends ItemNameBlockItem {
	public RosePotatoItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		if (level.getBlockState(context.getClickedPos()).getBlock() instanceof CropBlock crop && context.getPlayer() != null) {
			if (crop == FABlocks.EMPTY_ROOT.get()) {

			} else if (!crop.isMaxAge(context.getLevel().getBlockState(context.getClickedPos()))) {
				crop.growCrops(level, context.getClickedPos(), level.getBlockState(context.getClickedPos()));
				context.getPlayer().hurt(level.damageSources().magic(), 2.0f);
				context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
				this.getDefaultInstance().consume(1, context.getPlayer());
				return InteractionResult.sidedSuccess(true);
			}
		}
		return super.useOn(context);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
		tooltipComponents.add(Component.translatable(getDescriptionId() + ".tooltip").withStyle(ChatFormatting.RED));
	}
}
