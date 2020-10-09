package net.mcreator.halloween.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;

@HalloweenModElements.ModElement.Tag
public class BloodFoodEatenProcedure extends HalloweenModElements.ModElement {
	public BloodFoodEatenProcedure(HalloweenModElements instance) {
		super(instance, 37);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure BloodFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getBoolean("isVampire")) == (true))) {
			entity.getPersistentData().putDouble("bloodSaturation", 24000);
		}
	}
}
