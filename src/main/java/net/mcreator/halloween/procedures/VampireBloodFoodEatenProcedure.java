package net.mcreator.halloween.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;

@HalloweenModElements.ModElement.Tag
public class VampireBloodFoodEatenProcedure extends HalloweenModElements.ModElement {
	public VampireBloodFoodEatenProcedure(HalloweenModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VampireBloodFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("isVampire", (true));
	}
}
