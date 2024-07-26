package ho.artisan.farmaway.common.entity;

import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class PotatoLaserEntity extends Projectile implements ItemSupplier {
	private int lifetime;
	private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(
		PotatoLaserEntity.class, EntityDataSerializers.ITEM_STACK
	);
	private static final EntityDataAccessor<Boolean> NO_PHYSIC = SynchedEntityData.defineId(
		PotatoLaserEntity.class, EntityDataSerializers.BOOLEAN
	);
	private static final EntityDataAccessor<Integer> LIFE_TIME = SynchedEntityData.defineId(
		PotatoLaserEntity.class, EntityDataSerializers.INT
	);
	private static final EntityDataAccessor<Integer> SPLIT_CHANCE = SynchedEntityData.defineId(
		PotatoLaserEntity.class, EntityDataSerializers.INT
	);

	public PotatoLaserEntity(EntityType<? extends Projectile> entityType, Level level) {
		super(entityType, level);
	}

	public PotatoLaserEntity(Level level, LivingEntity shooter, int lifetime, double x, double y, double z) {
		this(FAEntities.POTATO_LASER.get(), level);
		this.lifetime = lifetime;
		this.setOwner(shooter);
		this.setPos(x, y + 1.5, z);
		this.setDeltaMovement(shooter.getViewVector(1.0F));
		this.noPhysics = false;
	}

	public PotatoLaserEntity(Level level, int lifetime, double x, double y, double z) {
		this(FAEntities.POTATO_LASER.get(), level);
		this.lifetime = lifetime;
		this.setOwner(this.getOwner());
		this.setPos(x, y + 1.5, z);
		this.noPhysics = false;
	}

	public PotatoLaserEntity(Level level, double x, double y, double z) {
		this(FAEntities.POTATO_LASER.get(), level);
		this.setPos(x, y, z);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		builder.define(DATA_ITEM_STACK, this.getItem());
		builder.define(NO_PHYSIC, this.noPhysics);
		builder.define(LIFE_TIME, 120);
		builder.define(SPLIT_CHANCE, 3);
	}

	@Override
	public ItemStack getItem() {
		return FAItems.GERBERA_POTATO.toStack();
	}

	@Override
	public void tick() {
		super.tick();
		this.lifetime -= 1;
		this.entityData.set(LIFE_TIME, this.entityData.get(LIFE_TIME));
//		double horizontal = this.horizontalCollision ? 1.0 : 1.15;
//		this.setDeltaMovement(this.getDeltaMovement().multiply(horizontal, 0.0, horizontal).add(0.0, -1.0, 0.0));

		Vec3 vec = this.getDeltaMovement();
		this.move(MoverType.SELF, vec);
		this.setDeltaMovement(vec);

		HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
		if (!this.noPhysics) {
			this.hitTargetOrDeflectSelf(hitresult);
			this.hasImpulse = true;
		}

		this.updateRotation();
		if (this.lifetime == 100 && !this.isSilent()) {
			this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.WIND_CHARGE_BURST, SoundSource.AMBIENT, 3.0F, 1.0F);
		}

		if (this.level().isClientSide) {
			this.level().addParticle(
				ParticleTypes.GLOW,
				this.getX(),
				this.getY(),
				this.getZ(),
				this.random.nextGaussian() * 0.05,
				-this.getDeltaMovement().y * 0.5,
				this.random.nextGaussian() * 0.05
			);
		}

		if (!this.level().isClientSide && this.entityData.get(LIFE_TIME) == 0) {
			this.discard();
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		this.entityData.set(SPLIT_CHANCE, this.entityData.get(SPLIT_CHANCE) - 1);
		if (this.entityData.get(SPLIT_CHANCE) > 0) {
			for (int i = 0; i < 2; i++) {
				PotatoLaserEntity laser = new PotatoLaserEntity(this.level(), this.entityData.get(LIFE_TIME), this.getX(), this.getY(), this.getZ());
				laser.entityData.set(SPLIT_CHANCE, this.entityData.get(SPLIT_CHANCE));
				Vec3 v = this.getForward();
				this.level().addFreshEntity(laser);
				if (i == 1) {
					laser.setDeltaMovement(v.x, -v.y, -v.z);
				} else {
					laser.setDeltaMovement(-v.x, -v.y, v.z);
				}
			}
		} else {
			Vec3 v = this.getForward();
			this.setDeltaMovement(-v.x, v.y, -v.z);
		}
		this.discard();
	}
}
