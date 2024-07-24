package ho.artisan.farmaway.common.entity;

import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

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
	public void tick() {
		super.tick();
		if (level().isClientSide) {
			Vec3 motion = this.getDeltaMovement();
			double x = this.getX() + motion.x;
			double y = this.getY() + motion.y;
			double z = this.getZ() + motion.z;
			this.level().addParticle(ParticleTypes.SMOKE, x, y + 0.5, z, 0.0, 0.0, 0.0);
			this.level().addParticle(ParticleTypes.WHITE_SMOKE, x, y + 0.5, z, 0.0, 0.0, 0.0);
			this.level().addParticle(ParticleTypes.ASH, x, y + 0.5, z, 0.0, 0.0, 0.0);
		}
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
