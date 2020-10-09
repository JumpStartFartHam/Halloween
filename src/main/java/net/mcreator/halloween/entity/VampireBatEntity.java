
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.halloween.procedures.VampireBatEntityIsHurtProcedure;
import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@HalloweenModElements.ModElement.Tag
public class VampireBatEntity extends HalloweenModElements.ModElement {
	public static EntityType entity = null;
	public VampireBatEntity(HalloweenModElements instance) {
		super(instance, 34);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("vampire_bat")
						.setRegistryName("vampire_bat");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -13421773, -6750208, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("vampire_bat"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelvampire_bat(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("halloween:textures/vampire_bat.png");
				}
			};
		});
	}
	public static class CustomEntity extends BatEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
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
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("sourceentity", sourceentity);
				VampireBatEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
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
	public static class Modelvampire_bat extends EntityModel<Entity> {
		private final ModelRenderer bat;
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer rightEar;
		private final ModelRenderer leftEar;
		private final ModelRenderer rightWing;
		private final ModelRenderer rightWingTip;
		private final ModelRenderer leftWing;
		private final ModelRenderer leftWingTip;
		public Modelvampire_bat() {
			textureWidth = 64;
			textureHeight = 64;
			bat = new ModelRenderer(this);
			bat.setRotationPoint(0.0F, 24.0F, 0.0F);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, -14.0F, 0.0F);
			bat.addChild(body);
			setRotationAngle(body, 0.7854F, 0.0F, 0.0F);
			body.setTextureOffset(0, 16).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, true);
			body.setTextureOffset(0, 34).addBox(-5.0F, 6.0F, 0.0F, 10.0F, 16.0F, 1.0F, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -9.0F, 0.0F);
			body.addChild(head);
			setRotationAngle(head, -0.7854F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
			rightEar = new ModelRenderer(this);
			rightEar.setRotationPoint(0.0F, -1.0F, 0.0F);
			head.addChild(rightEar);
			rightEar.setTextureOffset(24, 0).addBox(1.0F, -5.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
			leftEar = new ModelRenderer(this);
			leftEar.setRotationPoint(0.0F, -1.0F, 0.0F);
			head.addChild(leftEar);
			leftEar.setTextureOffset(24, 0).addBox(-4.0F, -5.0F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			rightWing = new ModelRenderer(this);
			rightWing.setRotationPoint(2.0F, -1.0F, 2.0F);
			body.addChild(rightWing);
			rightWing.setTextureOffset(42, 0).addBox(0.0F, -8.0F, -0.5F, 10.0F, 16.0F, 1.0F, 0.0F, true);
			rightWingTip = new ModelRenderer(this);
			rightWingTip.setRotationPoint(10.0F, -8.0F, -0.5F);
			rightWing.addChild(rightWingTip);
			rightWingTip.setTextureOffset(24, 16).addBox(0.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F, 0.0F, true);
			leftWing = new ModelRenderer(this);
			leftWing.setRotationPoint(-2.0F, -1.0F, 2.0F);
			body.addChild(leftWing);
			leftWing.setTextureOffset(42, 0).addBox(-10.0F, -8.0F, -0.5F, 10.0F, 16.0F, 1.0F, 0.0F, false);
			leftWingTip = new ModelRenderer(this);
			leftWingTip.setRotationPoint(-10.0F, -8.0F, -0.5F);
			leftWing.addChild(leftWingTip);
			leftWingTip.setTextureOffset(24, 16).addBox(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bat.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.leftWing.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.rightWing.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
