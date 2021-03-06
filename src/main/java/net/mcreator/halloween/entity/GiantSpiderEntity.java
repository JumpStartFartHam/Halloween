
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
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.halloween.procedures.GiantSpiderOnInitialEntitySpawnProcedure;
import net.mcreator.halloween.procedures.GiantSpiderOnEntityTickUpdateProcedure;
import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@HalloweenModElements.ModElement.Tag
public class GiantSpiderEntity extends HalloweenModElements.ModElement {
	public static EntityType entity = null;
	public GiantSpiderEntity(HalloweenModElements instance) {
		super(instance, 39);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(2.2f, 1f)).build("giant_spider")
						.setRegistryName("giant_spider");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -14606047, -5763570, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("giant_spider"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("plains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("desert")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("swamp")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_tundra")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("beach")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("desert_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("wooded_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("mountain_edge")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("jungle")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("jungle_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("jungle_edge")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("birch_forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("birch_forest_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("dark_forest")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_tree_taiga")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("giant_tree_taiga_hills")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("wooded_mountains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("savanna_plateau")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("badlands")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("wooded_badlands_plateau")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("badlands_plateau")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("bamboo_jungle")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("bamboo_jungle_hills")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 3, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelqueen_spider(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("halloween:textures/giant_spider.png");
				}
			};
		});
	}
	public static class CustomEntity extends SpiderEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 4;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.SPIDER_EYE, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), 0.15f,
					1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata,
				CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				GiantSpiderOnInitialEntitySpawnProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				GiantSpiderOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelqueen_spider extends EntityModel<Entity> {
		private final ModelRenderer giantspider;
		private final ModelRenderer head;
		private final ModelRenderer lmandible;
		private final ModelRenderer rmandible;
		private final ModelRenderer lforcep;
		private final ModelRenderer lforceplower;
		private final ModelRenderer rforcep;
		private final ModelRenderer rforceplower;
		private final ModelRenderer body;
		private final ModelRenderer body1;
		private final ModelRenderer body0;
		private final ModelRenderer rightlegs;
		private final ModelRenderer rightleg1;
		private final ModelRenderer rleg1;
		private final ModelRenderer rleglower1;
		private final ModelRenderer rightleg2;
		private final ModelRenderer rleg2;
		private final ModelRenderer rleglower2;
		private final ModelRenderer rightleg3;
		private final ModelRenderer rleg3;
		private final ModelRenderer rleglower3;
		private final ModelRenderer rightleg4;
		private final ModelRenderer rleg4;
		private final ModelRenderer rleglower4;
		private final ModelRenderer leftlegs;
		private final ModelRenderer leftleg1;
		private final ModelRenderer lleg1;
		private final ModelRenderer lleglower1;
		private final ModelRenderer leftleg2;
		private final ModelRenderer lleg2;
		private final ModelRenderer lleglower2;
		private final ModelRenderer leftleg3;
		private final ModelRenderer lleg3;
		private final ModelRenderer lleglower3;
		private final ModelRenderer leftleg4;
		private final ModelRenderer lleg4;
		private final ModelRenderer lleglower4;
		public Modelqueen_spider() {
			textureWidth = 256;
			textureHeight = 256;
			giantspider = new ModelRenderer(this);
			giantspider.setRotationPoint(0.0F, 25.0F, 0.0F);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -13.0F, -10.0F);
			giantspider.addChild(head);
			head.setTextureOffset(0, 44).addBox(-8.0F, -8.0F, -16.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			lmandible = new ModelRenderer(this);
			lmandible.setRotationPoint(4.0F, 4.0F, -16.0F);
			head.addChild(lmandible);
			setRotationAngle(lmandible, 0.0F, 0.0F, -0.3927F);
			lmandible.setTextureOffset(48, 46).addBox(-2.3827F, -2.0761F, -3.0F, 5.0F, 10.0F, 3.0F, 0.0F, false);
			lmandible.setTextureOffset(74, 51).addBox(2.6173F, 0.9239F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			rmandible = new ModelRenderer(this);
			rmandible.setRotationPoint(-4.0F, 4.0F, -16.0F);
			head.addChild(rmandible);
			setRotationAngle(rmandible, 0.0F, 0.0F, 0.3927F);
			rmandible.setTextureOffset(0, 46).addBox(-2.6173F, -2.0761F, -3.0F, 5.0F, 10.0F, 3.0F, 0.0F, false);
			rmandible.setTextureOffset(64, 51).addBox(-4.6173F, 0.9239F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, false);
			lforcep = new ModelRenderer(this);
			lforcep.setRotationPoint(8.0F, 1.0F, -8.0F);
			head.addChild(lforcep);
			setRotationAngle(lforcep, 0.0F, 0.0F, -0.3927F);
			lforcep.setTextureOffset(120, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			lforceplower = new ModelRenderer(this);
			lforceplower.setRotationPoint(0.0F, 6.0F, 0.0F);
			lforcep.addChild(lforceplower);
			setRotationAngle(lforceplower, -1.1781F, 0.0F, 0.0F);
			lforceplower.setTextureOffset(120, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			rforcep = new ModelRenderer(this);
			rforcep.setRotationPoint(-8.0F, 1.0F, -8.0F);
			head.addChild(rforcep);
			setRotationAngle(rforcep, 0.0F, 0.0F, 0.3927F);
			rforcep.setTextureOffset(128, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			rforceplower = new ModelRenderer(this);
			rforceplower.setRotationPoint(0.0F, 6.0F, 0.0F);
			rforcep.addChild(rforceplower);
			setRotationAngle(rforceplower, -1.1781F, 0.0F, 0.0F);
			rforceplower.setTextureOffset(128, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			giantspider.addChild(body);
			body1 = new ModelRenderer(this);
			body1.setRotationPoint(0.0F, -9.0F, 9.0F);
			body.addChild(body1);
			body1.setTextureOffset(0, 76).addBox(-10.0F, -12.0F, -3.0F, 20.0F, 16.0F, 4.0F, 0.0F, false);
			body1.setTextureOffset(72, 0).addBox(-10.0F, -12.0F, 25.0F, 20.0F, 16.0F, 4.0F, 0.0F, false);
			body1.setTextureOffset(0, 10).addBox(2.0F, -6.0F, 29.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			body1.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, 29.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			body1.setTextureOffset(0, 0).addBox(-12.0F, -14.0F, 1.0F, 24.0F, 20.0F, 24.0F, 0.0F, false);
			body0 = new ModelRenderer(this);
			body0.setRotationPoint(0.0F, -9.0F, 0.0F);
			body.addChild(body0);
			body0.setTextureOffset(48, 60).addBox(-7.0F, -10.0F, -10.0F, 14.0F, 12.0F, 16.0F, 0.0F, false);
			rightlegs = new ModelRenderer(this);
			rightlegs.setRotationPoint(3.0F, 0.0F, 0.0F);
			giantspider.addChild(rightlegs);
			rightleg1 = new ModelRenderer(this);
			rightleg1.setRotationPoint(-10.0F, -13.0F, -8.0F);
			rightlegs.addChild(rightleg1);
			rleg1 = new ModelRenderer(this);
			rleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightleg1.addChild(rleg1);
			setRotationAngle(rleg1, -0.6155F, -0.5236F, 0.9553F);
			rleg1.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			rleglower1 = new ModelRenderer(this);
			rleglower1.setRotationPoint(-12.0F, 0.0F, 0.0F);
			rleg1.addChild(rleglower1);
			setRotationAngle(rleglower1, 0.0F, 0.0F, -1.5708F);
			rleglower1.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			rightleg2 = new ModelRenderer(this);
			rightleg2.setRotationPoint(-10.0F, -13.0F, -4.0F);
			rightlegs.addChild(rightleg2);
			rleg2 = new ModelRenderer(this);
			rleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightleg2.addChild(rleg2);
			setRotationAngle(rleg2, -0.2849F, -0.274F, 0.8249F);
			rleg2.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			rleglower2 = new ModelRenderer(this);
			rleglower2.setRotationPoint(-12.0F, 0.0F, 0.0F);
			rleg2.addChild(rleglower2);
			setRotationAngle(rleglower2, 0.0F, 0.0F, -1.5708F);
			rleglower2.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			rightleg3 = new ModelRenderer(this);
			rightleg3.setRotationPoint(-10.0F, -13.0F, 0.0F);
			rightlegs.addChild(rightleg3);
			rleg3 = new ModelRenderer(this);
			rleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightleg3.addChild(rleg3);
			setRotationAngle(rleg3, 0.0F, 0.0F, 0.7854F);
			rleg3.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			rleglower3 = new ModelRenderer(this);
			rleglower3.setRotationPoint(-12.0F, 0.0F, 0.0F);
			rleg3.addChild(rleglower3);
			setRotationAngle(rleglower3, 0.0F, 0.0F, -1.5708F);
			rleglower3.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			rightleg4 = new ModelRenderer(this);
			rightleg4.setRotationPoint(-10.0F, -13.0F, 4.0F);
			rightlegs.addChild(rightleg4);
			rleg4 = new ModelRenderer(this);
			rleg4.setRotationPoint(0.0F, 0.0F, 0.0F);
			rightleg4.addChild(rleg4);
			setRotationAngle(rleg4, 0.2849F, 0.274F, 0.8249F);
			rleg4.setTextureOffset(96, 28).addBox(-14.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			rleglower4 = new ModelRenderer(this);
			rleglower4.setRotationPoint(-12.0F, 0.0F, 0.0F);
			rleg4.addChild(rleglower4);
			setRotationAngle(rleglower4, 0.0F, 0.0F, -1.5708F);
			rleglower4.setTextureOffset(96, 20).addBox(-26.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			leftlegs = new ModelRenderer(this);
			leftlegs.setRotationPoint(-3.0F, 0.0F, 0.0F);
			giantspider.addChild(leftlegs);
			leftleg1 = new ModelRenderer(this);
			leftleg1.setRotationPoint(10.0F, -13.0F, -8.0F);
			leftlegs.addChild(leftleg1);
			lleg1 = new ModelRenderer(this);
			lleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftleg1.addChild(lleg1);
			setRotationAngle(lleg1, -0.6155F, 0.5236F, -0.9553F);
			lleg1.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			lleglower1 = new ModelRenderer(this);
			lleglower1.setRotationPoint(12.0F, 0.0F, 0.0F);
			lleg1.addChild(lleglower1);
			setRotationAngle(lleglower1, 0.0F, 0.0F, 1.5708F);
			lleglower1.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			leftleg2 = new ModelRenderer(this);
			leftleg2.setRotationPoint(10.0F, -13.0F, -4.0F);
			leftlegs.addChild(leftleg2);
			lleg2 = new ModelRenderer(this);
			lleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftleg2.addChild(lleg2);
			setRotationAngle(lleg2, -0.2849F, 0.274F, -0.8249F);
			lleg2.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			lleglower2 = new ModelRenderer(this);
			lleglower2.setRotationPoint(12.0F, 0.0F, 0.0F);
			lleg2.addChild(lleglower2);
			setRotationAngle(lleglower2, 0.0F, 0.0F, 1.5708F);
			lleglower2.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			leftleg3 = new ModelRenderer(this);
			leftleg3.setRotationPoint(10.0F, -13.0F, 0.0F);
			leftlegs.addChild(leftleg3);
			lleg3 = new ModelRenderer(this);
			lleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftleg3.addChild(lleg3);
			setRotationAngle(lleg3, 0.0F, 0.0F, -0.7854F);
			lleg3.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			lleglower3 = new ModelRenderer(this);
			lleglower3.setRotationPoint(12.0F, 0.0F, 0.0F);
			lleg3.addChild(lleglower3);
			setRotationAngle(lleglower3, 3.1416F, 0.0F, 1.5708F);
			lleglower3.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
			leftleg4 = new ModelRenderer(this);
			leftleg4.setRotationPoint(10.0F, -13.0F, 4.0F);
			leftlegs.addChild(leftleg4);
			lleg4 = new ModelRenderer(this);
			lleg4.setRotationPoint(0.0F, 0.0F, 0.0F);
			leftleg4.addChild(lleg4);
			setRotationAngle(lleg4, 0.2849F, -0.274F, -0.8249F);
			lleg4.setTextureOffset(96, 28).addBox(0.0F, -2.0F, -2.0F, 14.0F, 4.0F, 4.0F, 0.0F, false);
			lleglower4 = new ModelRenderer(this);
			lleglower4.setRotationPoint(12.0F, 0.0F, 0.0F);
			lleg4.addChild(lleglower4);
			setRotationAngle(lleglower4, 0.0F, 0.0F, 1.5708F);
			lleglower4.setTextureOffset(96, 20).addBox(2.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			giantspider.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.rightleg4.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.rightleg3.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightleg2.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftleg4.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.leftleg3.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftleg2.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.leftleg1.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightleg1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
