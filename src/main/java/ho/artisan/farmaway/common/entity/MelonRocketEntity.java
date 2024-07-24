package ho.artisan.farmaway.common.entity;

import ho.artisan.farmaway.common.registry.FAEntities;
import ho.artisan.farmaway.common.registry.FAItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class MelonRocketEntity extends Projectile implements ItemSupplier {
	private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(
		MelonRocketEntity.class, EntityDataSerializers.ITEM_STACK
	);
	private int life;
	private int lifetime;
	public MelonRocketEntity(EntityType<? extends Projectile> entityType, Level level) {
		super(entityType, level);
	}
	public MelonRocketEntity(Level level, double x, double y, double z) {
		this(FAEntities.MELON_ROCKET.get(), level);
		this.life = 0;
		this.lifetime = 16 + this.random.nextInt(6) + this.random.nextInt(7);
		this.setPos(x, y, z);
	}
	public MelonRocketEntity(Level level, Entity shooter, double x, double y, double z) {
		this(level, x, y, z);
		this.setOwner(shooter);
	}

	private void explode() {
		this.level().broadcastEntityEvent(this, (byte) 17);
		this.gameEvent(GameEvent.EXPLODE, this.getOwner());
		for (int i = 0; i < 3; i++) {
			double f = RandomSource.create().nextDouble();
			ItemEntity seed = new ItemEntity(this.level(), this.getX() + f, this.getY(), this.getZ() + f, FAItems.MELON_ROCKET_SEED.toStack());
			this.level().addFreshEntity(seed);
			this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.FIREWORK_ROCKET_BLAST, SoundSource.AMBIENT, 3.0F, 1.0F);
		}
		this.discard();
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getOwner() instanceof LivingEntity living) {
			living.heal((living.getMaxHealth() - living.getHealth()) * 0.01f);
		}
		double d = this.horizontalCollision ? 1.0 : 1.15;
		this.setDeltaMovement(this.getDeltaMovement().multiply(d, 1.0, d).add(0.0, 0.04, 0.0));

		Vec3 v = this.getDeltaMovement();
		this.move(MoverType.SELF, v);
		this.setDeltaMovement(v);

		HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
		if (!this.noPhysics) {
			this.hitTargetOrDeflectSelf(hitresult);
			this.hasImpulse = true;
		}

		this.updateRotation();
		if (this.life == 0 && !this.isSilent()) {
			this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.FIREWORK_ROCKET_LAUNCH, SoundSource.AMBIENT, 3.0F, 1.0F);
		}

		this.life++;
		if (this.level().isClientSide) {
			this.level().addParticle(
				ParticleTypes.GLOW,
				this.getX(),
				this.getY(),
				this.getZ(),
				this.random.nextGaussian() * 0.15,
				-this.getDeltaMovement().y * 0.6,
				this.random.nextGaussian() * 0.25
			);
			this.level().addParticle(
				ParticleTypes.SOUL_FIRE_FLAME,
				this.getX(),
				this.getY(),
				this.getZ(),
				this.random.nextGaussian() * 0.5,
				-this.getDeltaMovement().y * 0.5,
				this.random.nextGaussian() * 0.5
			);
		}

		if (this.life > this.lifetime && !this.level().isClientSide) {
			this.explode();
		}
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		builder.define(DATA_ITEM_STACK, this.getItem());
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		if (!this.level().isClientSide) {
			this.discard();
		}
	}

	@Override
	protected void onHitBlock(BlockHitResult result) {
		this.level().getBlockState(result.getBlockPos()).entityInside(this.level(), result.getBlockPos(), this);
		if (!this.level().isClientSide()) {
			this.explode();
		}

		super.onHitBlock(result);
	}
	@Override
	public boolean isAttackable() {
		return false;
	}

	@Override
	public ItemStack getItem() {
		return FAItems.MELON_ROCKET.toStack();
	}
}
