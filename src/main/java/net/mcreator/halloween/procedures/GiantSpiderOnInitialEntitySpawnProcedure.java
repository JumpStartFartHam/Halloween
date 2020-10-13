package net.mcreator.halloween.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;

@HalloweenModElements.ModElement.Tag
public class GiantSpiderOnInitialEntitySpawnProcedure extends HalloweenModElements.ModElement {
	public GiantSpiderOnInitialEntitySpawnProcedure(HalloweenModElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GiantSpiderOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity)
					.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) Double.POSITIVE_INFINITY, (int) 4, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) Double.POSITIVE_INFINITY, (int) 0, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).setHealth(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 20f);
	}
}
