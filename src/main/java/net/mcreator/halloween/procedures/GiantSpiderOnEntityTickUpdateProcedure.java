package net.mcreator.halloween.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;
import java.util.Collection;

@HalloweenModElements.ModElement.Tag
public class GiantSpiderOnEntityTickUpdateProcedure extends HalloweenModElements.ModElement {
	public GiantSpiderOnEntityTickUpdateProcedure(HalloweenModElements instance) {
		super(instance, 46);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GiantSpiderOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(new Object() {
			boolean check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.HEALTH_BOOST)
							return true;
					}
				}
				return false;
			}
		}.check((LivingEntity) entity)))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) Double.POSITIVE_INFINITY, (int) 4, (false), (false)));
		}
		if ((!(new Object() {
			boolean check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == Effects.STRENGTH)
							return true;
					}
				}
				return false;
			}
		}.check((LivingEntity) entity)))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) Double.POSITIVE_INFINITY, (int) 0, (false), (false)));
		}
	}
}
