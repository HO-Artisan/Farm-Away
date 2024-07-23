package ho.artisan.farmaway.common.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

public class StrongCarrotItem extends BlockItem {
	public StrongCarrotItem(Block block, Properties properties) {
		super(block, properties.component(DataComponents.TOOL, createToolProperties()));
	}

	public static Tool createToolProperties() {
		return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
		return super.canPerformAction(stack, itemAbility) || ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(itemAbility);
	}
}
