
package net.mcreator.halloween.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.halloween.HalloweenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@HalloweenModElements.ModElement.Tag
public class MagmaFiendEntity extends HalloweenModElements.ModElement {
	public static EntityType entity = null;
	public MagmaFiendEntity(HalloweenModElements instance) {
		super(instance, 41);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 2.5f))
						.build("magma_fiend").setRegistryName("magma_fiend");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -13434880, -752350, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("magma_fiend"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("nether")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 2, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmagma_fiend(), 1f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("halloween:textures/magma_fiend_texture.png");
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
			experienceValue = 5;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, IronGolemEntity.class, false, false));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, VillagerEntity.class, false, false));
			this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(8, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEyes(new ResourceLocation("halloween:textures/magma_fiend_glowing.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelmagma_fiend extends EntityModel<Entity> {
		private final ModelRenderer winged_fiend;
		private final ModelRenderer head;
		private final ModelRenderer snout;
		private final ModelRenderer lhorn1;
		private final ModelRenderer lhorn2;
		private final ModelRenderer lhorn3;
		private final ModelRenderer rhorn1;
		private final ModelRenderer rhorn2;
		private final ModelRenderer rhorn3;
		private final ModelRenderer body;
		private final ModelRenderer torsoupper;
		private final ModelRenderer torsolower;
		private final ModelRenderer lwing;
		private final ModelRenderer rwing;
		private final ModelRenderer tail1;
		private final ModelRenderer tail2;
		private final ModelRenderer rightarm;
		private final ModelRenderer leftarm;
		private final ModelRenderer rightleg;
		private final ModelRenderer leftleg;
		public Modelmagma_fiend() {
			textureWidth = 256;
			textureHeight = 256;
			winged_fiend = new ModelRenderer(this);
			winged_fiend.setRotationPoint(0.0F, 26.0F, 0.0F);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -44.0F, -10.0F);
			winged_fiend.addChild(head);
			head.setTextureOffset(0, 0).addBox(-7.0F, -14.0F, -9.0F, 14.0F, 14.0F, 14.0F, 0.0F, true);
			snout = new ModelRenderer(this);
			snout.setRotationPoint(-5.0F, -7.0F, -14.0F);
			head.addChild(snout);
			snout.setTextureOffset(58, 17).addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 5.0F, 0.0F, true);
			lhorn1 = new ModelRenderer(this);
			lhorn1.setRotationPoint(4.0F, -16.0F, -8.0F);
			head.addChild(lhorn1);
			lhorn1.setTextureOffset(88, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
			lhorn2 = new ModelRenderer(this);
			lhorn2.setRotationPoint(5.0F, -17.0F, -7.0F);
			head.addChild(lhorn2);
			lhorn2.setTextureOffset(88, 4).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);
			lhorn3 = new ModelRenderer(this);
			lhorn3.setRotationPoint(6.0F, -18.0F, -6.0F);
			head.addChild(lhorn3);
			lhorn3.setTextureOffset(88, 10).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			rhorn1 = new ModelRenderer(this);
			rhorn1.setRotationPoint(-7.0F, -16.0F, -8.0F);
			head.addChild(rhorn1);
			rhorn1.setTextureOffset(88, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, true);
			rhorn2 = new ModelRenderer(this);
			rhorn2.setRotationPoint(-7.0F, -17.0F, -7.0F);
			head.addChild(rhorn2);
			rhorn2.setTextureOffset(88, 5).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, true);
			rhorn3 = new ModelRenderer(this);
			rhorn3.setRotationPoint(-7.0F, -18.0F, -6.0F);
			head.addChild(rhorn3);
			rhorn3.setTextureOffset(88, 10).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(4.0F, -60.0F, -18.0F);
			winged_fiend.addChild(body);
			torsoupper = new ModelRenderer(this);
			torsoupper.setRotationPoint(-13.0F, 19.0F, 4.0F);
			body.addChild(torsoupper);
			setRotationAngle(torsoupper, 0.6109F, 0.0F, 0.0F);
			torsoupper.setTextureOffset(0, 29).addBox(0.0F, 0.0F, 0.0F, 18.0F, 12.0F, 10.0F, 0.0F, true);
			torsolower = new ModelRenderer(this);
			torsolower.setRotationPoint(-12.0F, 26.0F, 11.0F);
			body.addChild(torsolower);
			setRotationAngle(torsolower, 0.2618F, 0.0F, 0.0F);
			torsolower.setTextureOffset(0, 52).addBox(0.0F, 0.0F, 0.0F, 16.0F, 12.0F, 8.0F, 0.0F, true);
			lwing = new ModelRenderer(this);
			lwing.setRotationPoint(-3.0F, 9.0F, 9.0F);
			body.addChild(lwing);
			setRotationAngle(lwing, 0.6109F, -0.3491F, -0.2618F);
			lwing.setTextureOffset(0, 222).addBox(0.0F, 0.0F, 0.0F, 52.0F, 34.0F, 0.0F, 0.0F, true);
			rwing = new ModelRenderer(this);
			rwing.setRotationPoint(-52.0F, -4.0F, 26.0F);
			body.addChild(rwing);
			setRotationAngle(rwing, 0.6109F, 0.3491F, 0.2618F);
			rwing.setTextureOffset(152, 222).addBox(0.0F, 0.0F, 0.0F, 52.0F, 34.0F, 0.0F, 0.0F, true);
			tail1 = new ModelRenderer(this);
			tail1.setRotationPoint(-7.0F, 33.0F, 22.0F);
			body.addChild(tail1);
			setRotationAngle(tail1, -0.8727F, 0.0F, 0.0F);
			tail1.setTextureOffset(104, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 20.0F, 0.0F, true);
			tail2 = new ModelRenderer(this);
			tail2.setRotationPoint(-6.0F, 47.0F, 32.0F);
			body.addChild(tail2);
			setRotationAngle(tail2, -0.3604F, 0.0F, 0.0F);
			tail2.setTextureOffset(156, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 5.0F, 20.0F, 0.0F, true);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-9.0F, -43.0F, -8.0F);
			winged_fiend.addChild(rightarm);
			rightarm.setTextureOffset(68, 42).addBox(-6.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, true);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(9.0F, -43.0F, -8.0F);
			winged_fiend.addChild(leftarm);
			leftarm.setTextureOffset(93, 42).addBox(0.0F, -1.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, true);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-5.0F, -24.0F, 0.0F);
			winged_fiend.addChild(rightleg);
			rightleg.setTextureOffset(32, 74).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 22.0F, 8.0F, 0.0F, true);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(5.0F, -24.0F, 0.0F);
			winged_fiend.addChild(leftleg);
			leftleg.setTextureOffset(0, 74).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 22.0F, 8.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			winged_fiend.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
