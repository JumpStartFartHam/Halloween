
package net.mcreator.halloween.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Random;
import java.util.EnumSet;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@HalloweenModElements.ModElement.Tag
public class ReaperEntity extends HalloweenModElements.ModElement {
	public static EntityType entity = null;
	public ReaperEntity(HalloweenModElements instance) {
		super(instance, 16);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1.2f, 2f)).build("reaper")
						.setRegistryName("reaper");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelReaper(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("halloween:textures/reaper.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 10;
			setNoAI(false);
			enablePersistence();
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false));
			this.goalSelector.addGoal(2, new Goal() {
				{
					this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
				}
				public boolean shouldExecute() {
					if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null
							&& CustomEntity.this.getAttackTarget().isAlive();
				}

				@Override
				public void startExecuting() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					Vec3d vec3d = livingentity.getEyePosition(1);
					CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
				}

				@Override
				public void tick() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
						CustomEntity.this.attackEntityAsMob(livingentity);
					} else {
						double d0 = CustomEntity.this.getDistanceSq(livingentity);
						if (d0 < 16) {
							Vec3d vec3d = livingentity.getEyePosition(1);
							CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
						}
					}
				}
			});
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelReaper extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer hood1;
		private final ModelRenderer hood2;
		private final ModelRenderer hood3;
		private final ModelRenderer hood4;
		private final ModelRenderer neck;
		private final ModelRenderer rightarm;
		private final ModelRenderer rightarmupper;
		private final ModelRenderer rightarmlower;
		private final ModelRenderer scythe;
		private final ModelRenderer scythe1;
		private final ModelRenderer scythe2;
		private final ModelRenderer scythe3;
		private final ModelRenderer scythe4;
		private final ModelRenderer scythe5;
		private final ModelRenderer staff;
		private final ModelRenderer leftarm;
		private final ModelRenderer leftarmupper;
		private final ModelRenderer leftarmlower;
		private final ModelRenderer body;
		private final ModelRenderer torso1;
		private final ModelRenderer torso2;
		private final ModelRenderer torso3;
		private final ModelRenderer torso4;
		public ModelReaper() {
			textureWidth = 128;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -2.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);
			hood1 = new ModelRenderer(this);
			hood1.setRotationPoint(-5.0F, -11.0F, -5.0F);
			head.addChild(hood1);
			hood1.setTextureOffset(32, 0).addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 10.0F, 0.0F, true);
			hood2 = new ModelRenderer(this);
			hood2.setRotationPoint(-4.0F, -12.0F, 4.0F);
			head.addChild(hood2);
			hood2.setTextureOffset(72, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 3.0F, 0.0F, true);
			hood3 = new ModelRenderer(this);
			hood3.setRotationPoint(-3.0F, -13.0F, 6.0F);
			head.addChild(hood3);
			hood3.setTextureOffset(94, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 3.0F, 0.0F, true);
			hood4 = new ModelRenderer(this);
			hood4.setRotationPoint(-2.0F, -14.0F, 7.0F);
			head.addChild(hood4);
			hood4.setTextureOffset(112, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 4.0F, 0.0F, true);
			neck = new ModelRenderer(this);
			neck.setRotationPoint(-1.0F, -1.0F, -1.0F);
			head.addChild(neck);
			neck.setTextureOffset(8, 16).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-10.0F, 0.0F, 0.0F);
			rightarmupper = new ModelRenderer(this);
			rightarmupper.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightarm.addChild(rightarmupper);
			setRotationAngle(rightarmupper, -0.3655F, 0.147F, 0.3655F);
			rightarmupper.setTextureOffset(0, 77).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);
			rightarmlower = new ModelRenderer(this);
			rightarmlower.setRotationPoint(-1.0F, 11.0F, 0.0F);
			rightarmupper.addChild(rightarmlower);
			setRotationAngle(rightarmlower, -0.7854F, 0.0F, -0.3927F);
			rightarmlower.setTextureOffset(0, 92).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);
			scythe = new ModelRenderer(this);
			scythe.setRotationPoint(0.0F, 13.0F, 6.0F);
			rightarmlower.addChild(scythe);
			setRotationAngle(scythe, 1.5708F, 0.0F, 0.0F);
			scythe1 = new ModelRenderer(this);
			scythe1.setRotationPoint(-1.0F, -36.0F, -7.0F);
			scythe.addChild(scythe1);
			scythe1.setTextureOffset(50, 35).addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 8.0F, 0.0F, true);
			scythe2 = new ModelRenderer(this);
			scythe2.setRotationPoint(-1.0F, -34.0F, -8.0F);
			scythe.addChild(scythe2);
			scythe2.setTextureOffset(50, 49).addBox(0.0F, 0.0F, -1.0F, 3.0F, 6.0F, 2.0F, 0.0F, true);
			scythe3 = new ModelRenderer(this);
			scythe3.setRotationPoint(-1.0F, -32.0F, -9.0F);
			scythe.addChild(scythe3);
			scythe3.setTextureOffset(60, 49).addBox(0.0F, 0.0F, -2.0F, 3.0F, 6.0F, 2.0F, 0.0F, true);
			scythe4 = new ModelRenderer(this);
			scythe4.setRotationPoint(-1.0F, -30.0F, -10.0F);
			scythe.addChild(scythe4);
			scythe4.setTextureOffset(50, 57).addBox(0.0F, 0.0F, -3.0F, 3.0F, 6.0F, 2.0F, 0.0F, true);
			scythe5 = new ModelRenderer(this);
			scythe5.setRotationPoint(-1.0F, -28.0F, -10.0F);
			scythe.addChild(scythe5);
			scythe5.setTextureOffset(60, 57).addBox(0.0F, 0.0F, -4.0F, 3.0F, 6.0F, 1.0F, 0.0F, true);
			staff = new ModelRenderer(this);
			staff.setRotationPoint(-1.0F, -32.0F, -2.0F);
			scythe.addChild(staff);
			staff.setTextureOffset(72, 20).addBox(0.0F, 2.0F, 0.0F, 3.0F, 30.0F, 3.0F, 0.0F, true);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(10.0F, 0.0F, 0.0F);
			setRotationAngle(leftarm, 0.0F, 0.0F, -0.3927F);
			leftarmupper = new ModelRenderer(this);
			leftarmupper.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftarm.addChild(leftarmupper);
			setRotationAngle(leftarmupper, -0.3927F, 0.0F, 0.0F);
			leftarmupper.setTextureOffset(0, 77).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);
			leftarmlower = new ModelRenderer(this);
			leftarmlower.setRotationPoint(1.0F, 11.0F, 0.0F);
			leftarmupper.addChild(leftarmlower);
			setRotationAngle(leftarmlower, -0.7854F, 0.0F, 0.3927F);
			leftarmlower.setTextureOffset(0, 92).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 12.0F, 3.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			torso1 = new ModelRenderer(this);
			torso1.setRotationPoint(-10.0F, -25.0F, -4.0F);
			body.addChild(torso1);
			setRotationAngle(torso1, 0.2231F, 0.0F, 0.0F);
			torso1.setTextureOffset(0, 20).addBox(0.0F, 0.0F, 0.0F, 20.0F, 7.0F, 8.0F, 0.0F, true);
			torso2 = new ModelRenderer(this);
			torso2.setRotationPoint(-8.0F, -18.0F, -2.0F);
			body.addChild(torso2);
			setRotationAngle(torso2, 0.5205F, 0.0F, 0.0F);
			torso2.setTextureOffset(0, 35).addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 7.0F, 0.0F, true);
			torso3 = new ModelRenderer(this);
			torso3.setRotationPoint(-5.0F, -10.0F, 3.0F);
			body.addChild(torso3);
			setRotationAngle(torso3, 1.041F, 0.0F, 0.0F);
			torso3.setTextureOffset(0, 51).addBox(0.0F, 0.0F, 0.0F, 10.0F, 9.0F, 5.0F, 0.0F, true);
			torso4 = new ModelRenderer(this);
			torso4.setRotationPoint(-3.0F, -6.0F, 11.0F);
			body.addChild(torso4);
			setRotationAngle(torso4, 1.3384F, 0.0F, 0.0F);
			torso4.setTextureOffset(0, 65).addBox(0.0F, 0.0F, 0.0F, 6.0F, 9.0F, 3.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
			leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
			body.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
