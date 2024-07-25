package ho.artisan.farmaway.common.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;

public class RosePotatoItem extends ItemNameBlockItem {
	public RosePotatoItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		if (level.getBlockState(context.getClickedPos()).getBlock() instanceof CropBlock crop && context.getPlayer() != null) {
			crop.growCrops(level, context.getClickedPos(), level.getBlockState(context.getClickedPos()));
			context.getPlayer().hurt(level.damageSources().magic(), 2.0f);
			context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
			this.getDefaultInstance().consume(1, context.getPlayer());
			return InteractionResult.sidedSuccess(true);
		}
		return super.useOn(context);
	}
}
