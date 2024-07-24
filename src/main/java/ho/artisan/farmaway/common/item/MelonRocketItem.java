package ho.artisan.farmaway.common.item;

import ho.artisan.farmaway.common.entity.MelonRocketEntity;
import ho.artisan.farmaway.common.registry.FAEntities;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class MelonRocketItem extends Item implements ProjectileItem {
	public MelonRocketItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level level = context.getLevel();
		Player player = context.getPlayer();
		if (!level.isClientSide && player != null && player.isCrouching()) {
			ItemStack itemstack = context.getItemInHand();
			Vec3 vec3 = context.getClickLocation();
			Direction direction = context.getClickedFace();
			MelonRocketEntity melon = new MelonRocketEntity(
				level,
				player,
				vec3.x + (double)direction.getStepX() * 0.15,
				vec3.y + (double)direction.getStepY() * 0.15,
				vec3.z + (double)direction.getStepZ() * 0.15
			);
			level.addFreshEntity(melon);
			itemstack.shrink(1);
			return InteractionResult.sidedSuccess(false);
		}

		return super.useOn(context);
	}

	@Override
	public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
		return new MelonRocketEntity(level, pos.x(), pos.y(), pos.z());
	}

	@Override
	public ProjectileItem.DispenseConfig createDispenseConfig() {
		return ProjectileItem.DispenseConfig.builder()
			.positionFunction(MelonRocketItem::getEntityPokingOutOfBlockPos)
			.uncertainty(1.0F)
			.power(0.5F)
			.overrideDispenseEvent(1004)
			.build();
	}

	private static Vec3 getEntityPokingOutOfBlockPos(BlockSource source, Direction direction) {
		return source.center().add(
				(double)direction.getStepX() * (0.5000099999997474 - (double) FAEntities.MELON_ROCKET.get().getWidth() / 2.0),
				(double)direction.getStepY() * (0.5000099999997474 - (double) FAEntities.MELON_ROCKET.get().getHeight() / 2.0) - (double) FAEntities.MELON_ROCKET.get().getHeight() / 2.0,
				(double)direction.getStepZ() * (0.5000099999997474 - (double) FAEntities.MELON_ROCKET.get().getWidth() / 2.0)
		);
	}
}
