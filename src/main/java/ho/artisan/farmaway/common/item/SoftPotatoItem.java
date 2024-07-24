package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

public class SoftPotatoItem extends ItemNameBlockItem {
	public SoftPotatoItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		if (context.getPlayer() != null) {
			if (context.getLevel().getBlockState(context.getClickedPos()).is(FABlocks.PHANTOM_DIRT)) {
				context.getPlayer().setHealth(context.getPlayer().getMaxHealth());
				context.getItemInHand().consume(1, context.getPlayer());
				return InteractionResult.sidedSuccess(true);
			} else if (context.getLevel().getBlockState(context.getClickedPos()).is(Tags.Blocks.STONES)) {
				context.getLevel().setBlock(context.getClickedPos(), Blocks.GOLD_ORE.defaultBlockState(), 2);
				context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
				context.getItemInHand().consume(1, context.getPlayer());
				context.getPlayer().setHealth(1.0f);
				context.getLevel().playSound(null, context.getPlayer().getX(), context.getPlayer().getY(), context.getPlayer().getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.NEUTRAL, 0.5F, 0.4F / (context.getLevel().getRandom().nextFloat() * 0.4F + 0.8F));
				return InteractionResult.sidedSuccess(true);
			}
		}
		return InteractionResult.PASS;
	}
}
