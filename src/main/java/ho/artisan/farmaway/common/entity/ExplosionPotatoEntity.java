package ho.artisan.farmaway.common.entity;

import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class ExplosionPotatoEntity extends ThrowableItemProjectile {
	public ExplosionPotatoEntity(EntityType<? extends ExplosionPotatoEntity> entityType, Level level) {
		super(entityType, level);
	}

	public ExplosionPotatoEntity(Level level, LivingEntity shooter) {
		super(FAEntities.EXPLOSION_POTATO.get(), shooter, level);
	}

	public ExplosionPotatoEntity(Level level, double x, double y, double z) {
		super(FAEntities.EXPLOSION_POTATO.get(), x, y, z, level);
	}

	@Override
	protected Item getDefaultItem() {
		return FAItems.EXPLOSION_POTATO.get();
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		if (!level().isClientSide) {
			level().explode(this, this.getX(), this.getY(), this.getZ(), 1.5F, true, Level.ExplosionInteraction.TNT);
			this.discard();
		}
	}
}
