package ho.artisan.farmaway.common.entity;

import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class PhantomBeetrootEntity extends ThrowableItemProjectile {
	public PhantomBeetrootEntity(EntityType<? extends PhantomBeetrootEntity> entityType, Level level) {
		super(entityType, level);
	}

	public PhantomBeetrootEntity(Level level, LivingEntity shooter) {
		super(FAEntities.PHANTOM_BEETROOT.get(), shooter, level);
	}

	public PhantomBeetrootEntity(Level level, double x, double y, double z) {
		super(FAEntities.PHANTOM_BEETROOT.get(), x, y, z, level);
	}

	@Override
	protected Item getDefaultItem() {
		return FAItems.PHANTOM_BEETROOT.get();
	}

	@Override
	public void tick() {
		super.tick();
		if (level().isClientSide) {
			Vec3 motion = this.getDeltaMovement();
			double x = this.getX() + motion.x;
			double y = this.getY() + motion.y;
			double z = this.getZ() + motion.z;
			this.level().addParticle(ParticleTypes.GLOW, x, y + 0.5, z, 0.0, 0.0, 0.0);
			this.level().addParticle(ParticleTypes.PORTAL, x, y + 0.5, z, 0.0, 0.0, 0.0);
		}
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
				for (int i = 0; i < 16; i++) {
					double x = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
					double y = Mth.clamp(entity.getY() + (double) (entity.getRandom().nextInt(16) - 8), level.getMinBuildHeight(), level.getMinBuildHeight() + ((ServerLevel) level).getLogicalHeight() - 1);
					double z = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * 16.0;
					if (entity.isPassenger()) {
						entity.stopRiding();
					}
					Vec3 vec3 = entity.position();
					entity.randomTeleport(x, y, z, true);
					level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(entity));
					this.discard();
				}
			}
		}
	}
}
