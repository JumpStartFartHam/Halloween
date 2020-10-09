package net.mcreator.halloween.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;
import java.util.Collection;

@HalloweenModElements.ModElement.Tag
public class VampirismOnPotionActiveTickProcedure extends HalloweenModElements.ModElement {
	public VampirismOnPotionActiveTickProcedure(HalloweenModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VampirismOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VampirismOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VampirismOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VampirismOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VampirismOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.canBlockSeeSky(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 0), (int) (entity.getPosZ())))) == (true))
				&& ((world.getWorld().isDaytime()) == (true)))) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 5, 1, 1, 1, 0);
			}
			entity.attackEntityFrom(DamageSource.ON_FIRE, (float) 2);
		} else {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 5, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 5, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 5, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 5, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 1f);
		}
		if ((new Object() {
			boolean check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.INSTANT_HEALTH)
							return true;
					}
				}
				return false;
			}
		}.check((LivingEntity) entity))) {
			entity.attackEntityFrom(DamageSource.MAGIC, (float) ((new Object() {
				int check(LivingEntity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = _entity.getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.INSTANT_HEALTH)
								return effect.getAmplifier();
						}
					}
					return 0;
				}
			}.check((LivingEntity) entity)) * 4));
			((LivingEntity) entity).removePotionEffect(Effects.INSTANT_HEALTH);
		}
		if ((new Object() {
			boolean check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.REGENERATION)
							return true;
					}
				}
				return false;
			}
		}.check((LivingEntity) entity))) {
			entity.attackEntityFrom(DamageSource.MAGIC, (float) ((new Object() {
				int check(LivingEntity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = _entity.getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.REGENERATION)
								return effect.getAmplifier();
						}
					}
					return 0;
				}
			}.check((LivingEntity) entity)) * 4));
			((LivingEntity) entity).removePotionEffect(Effects.REGENERATION);
		}
		if (((entity.getPersistentData().getDouble("bloodSaturation")) == 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 5, (int) 1, (false), (false)));
		} else {
			entity.getPersistentData().putDouble("bloodSaturation", ((entity.getPersistentData().getDouble("bloodSaturation")) - 1));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 5, (int) 0, (false), (false)));
		}
	}
}
