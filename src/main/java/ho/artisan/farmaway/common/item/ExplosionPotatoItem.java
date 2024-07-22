package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.registry.FABlocks;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplosionPotatoItem extends BlockItem /*implements ProjectileItem*/ {
	public ExplosionPotatoItem(Properties properties) {
		super(FABlocks.EXPLOSION_POTATO.get(), properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		return super.use(level, player, usedHand);
	}

//	@Override
//	public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
//		ExplosionPotatoEntity potato = new ExplosionPotatoEntity()
//		return ;
//	}
}
