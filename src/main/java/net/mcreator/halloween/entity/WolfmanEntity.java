
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
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.FollowMobGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.halloween.HalloweenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@HalloweenModElements.ModElement.Tag
public class WolfmanEntity extends HalloweenModElements.ModElement {
	public static EntityType entity = null;
	public WolfmanEntity(HalloweenModElements instance) {
		super(instance, 44);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("wolfman")
						.setRegistryName("wolfman");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -1777953, -3620157, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("wolfman"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_tree_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_tree_taiga_hills")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 1, 1, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelwolfman(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("halloween:textures/wolfman.png");
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
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ChickenEntity.class, false, false));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(4, new FollowMobGoal(this, (float) 1, 10, 5));
			this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, (float) 0.5));
			this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(7, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(9, new SwimGoal(this));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelwolfman extends EntityModel<Entity> {
		private final ModelRenderer wolfman;
		private final ModelRenderer head;
		private final ModelRenderer WolfHead;
		private final ModelRenderer Ear1;
		private final ModelRenderer Ear2;
		private final ModelRenderer Nose;
		private final ModelRenderer body;
		private final ModelRenderer torso;
		private final ModelRenderer mane;
		private final ModelRenderer tail;
		private final ModelRenderer leftarm;
		private final ModelRenderer larm;
		private final ModelRenderer rightarm;
		private final ModelRenderer rarm;
		private final ModelRenderer leftleg;
		private final ModelRenderer lleg;
		private final ModelRenderer rightleg;
		private final ModelRenderer rleg;
		public Modelwolfman() {
			textureWidth = 64;
			textureHeight = 64;
			wolfman = new ModelRenderer(this);
			wolfman.setRotationPoint(1.0F, 24.0F, -1.0F);
			head = new ModelRenderer(this);
			head.setRotationPoint(-1.0F, -23.0F, -3.0F);
			wolfman.addChild(head);
			WolfHead = new ModelRenderer(this);
			WolfHead.setRotationPoint(-4.0F, -4.0F, -5.0F);
			head.addChild(WolfHead);
			WolfHead.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 6.0F, 0.0F, true);
			Ear1 = new ModelRenderer(this);
			Ear1.setRotationPoint(-4.0F, -6.5F, -4.0F);
			head.addChild(Ear1);
			Ear1.setTextureOffset(32, 15).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
			Ear2 = new ModelRenderer(this);
			Ear2.setRotationPoint(1.0F, -6.5F, -4.0F);
			head.addChild(Ear2);
			Ear2.setTextureOffset(32, 15).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, true);
			Nose = new ModelRenderer(this);
			Nose.setRotationPoint(-2.5F, 0.0F, -8.0F);
			head.addChild(Nose);
			Nose.setTextureOffset(44, 15).addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 5.0F, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			wolfman.addChild(body);
			torso = new ModelRenderer(this);
			torso.setRotationPoint(-5.0F, -22.0F, -4.0F);
			body.addChild(torso);
			setRotationAngle(torso, 0.2603F, 0.0F, 0.0F);
			torso.setTextureOffset(20, 30).addBox(0.0F, 0.0F, 0.0F, 8.0F, 12.0F, 6.0F, 0.0F, true);
			mane = new ModelRenderer(this);
			mane.setRotationPoint(-5.0F, -19.0F, -6.0F);
			body.addChild(mane);
			setRotationAngle(mane, 1.0131F, 0.0F, 0.0F);
			mane.setTextureOffset(30, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 8.0F, 0.0F, true);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(-2.0F, -12.0F, 3.0F);
			body.addChild(tail);
			setRotationAngle(tail, 0.8727F, 0.0F, 0.0F);
			tail.setTextureOffset(26, 53).addBox(0.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F, 0.0F, true);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(3.0F, -21.0F, -2.0F);
			wolfman.addChild(leftarm);
			larm = new ModelRenderer(this);
			larm.setRotationPoint(2.0F, 0.0F, 0.0F);
			leftarm.addChild(larm);
			setRotationAngle(larm, -0.1396F, 0.0F, 0.0F);
			larm.setTextureOffset(0, 18).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-5.0F, -21.0F, -2.0F);
			wolfman.addChild(rightarm);
			rarm = new ModelRenderer(this);
			rarm.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightarm.addChild(rarm);
			setRotationAngle(rarm, -0.1396F, 0.0F, 0.0F);
			rarm.setTextureOffset(0, 18).addBox(-4.0F, -0.7119F, -2.1197F, 4.0F, 12.0F, 4.0F, 0.0F, true);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(1.0F, -12.0F, 1.5F);
			wolfman.addChild(leftleg);
			lleg = new ModelRenderer(this);
			lleg.setRotationPoint(-2.0F, 0.0F, -2.5F);
			leftleg.addChild(lleg);
			lleg.setTextureOffset(0, 47).addBox(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 5.0F, 0.0F, true);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
			wolfman.addChild(rightleg);
			rleg = new ModelRenderer(this);
			rleg.setRotationPoint(-3.0F, -12.0F, 1.5F);
			rightleg.addChild(rleg);
			rleg.setTextureOffset(0, 47).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 12.0F, 5.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			wolfman.render(matrixStack, buffer, packedLight, packedOverlay);
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
