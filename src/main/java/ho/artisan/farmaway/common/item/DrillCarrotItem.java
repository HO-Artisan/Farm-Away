package ho.artisan.farmaway.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class DrillCarrotItem extends ItemNameBlockItem {
	public DrillCarrotItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		BlockPos blockPos = context.getClickedPos();
		if (context.getPlayer() != null && context.getPlayer().isCrouching()) {
			level.destroyBlock(blockPos, false);
			context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
			context.getItemInHand().consume(1, context.getPlayer());
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
