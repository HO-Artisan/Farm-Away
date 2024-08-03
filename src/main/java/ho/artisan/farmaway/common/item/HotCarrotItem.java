package ho.artisan.farmaway.common.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class HotCarrotItem extends ItemNameBlockItem {
	public HotCarrotItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		ItemStack itemstack = player.getItemInHand(usedHand);
		FoodProperties foodproperties = itemstack.getFoodProperties(player);
		if (player.canEat(foodproperties.canAlwaysEat())) {
			player.startUsingItem(usedHand);
			return InteractionResultHolder.consume(itemstack);
		} else {
			return InteractionResultHolder.fail(itemstack);
		}
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		return super.finishUsingItem(stack, level, livingEntity);
	}
}
