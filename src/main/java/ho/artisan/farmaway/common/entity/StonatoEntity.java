package ho.artisan.farmaway.common.entity;

import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class StonatoEntity extends ThrowableItemProjectile {
	public StonatoEntity(EntityType<? extends StonatoEntity> entityType, Level level) {
		super(entityType, level);
	}

	public StonatoEntity(Level level, LivingEntity shooter) {
		super(FAEntities.STONATO.get(), shooter, level);
	}

	public StonatoEntity(Level level, double x, double y, double z) {
		super(FAEntities.STONATO.get(), x, y, z, level);
	}

	@Override
	protected Item getDefaultItem() {
		return FAItems.STONATO.get();
	}

	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		if (!level().isClientSide) {
			this.discard();
		}
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		if (result.getEntity() instanceof LivingEntity entity) {
			Level level = entity.level();
			if (!level.isClientSide) {
				entity.hurt(level.damageSources().magic(), 4.0f);
				this.discard();
			}
		}
	}
}
