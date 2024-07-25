package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.entity.PotatoLaserEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class GerberaPotatoItem extends ItemNameBlockItem implements ProjectileItem {
	public GerberaPotatoItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
		return new PotatoLaserEntity(level, pos.x(), pos.y(), pos.z());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		if (player.isCrouching()) {
			PotatoLaserEntity laser = new PotatoLaserEntity(level, player, 120, player.getX(), player.getY(), player.getZ());
			level.addFreshEntity(laser);
			return InteractionResultHolder.consume(player.getItemInHand(usedHand));
		} else {
			return super.use(level, player, usedHand);
		}
	}
}
