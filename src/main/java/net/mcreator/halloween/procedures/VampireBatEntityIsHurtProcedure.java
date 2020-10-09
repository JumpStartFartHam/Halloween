package net.mcreator.halloween.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;

@HalloweenModElements.ModElement.Tag
public class VampireBatEntityIsHurtProcedure extends HalloweenModElements.ModElement {
	public VampireBatEntityIsHurtProcedure(HalloweenModElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VampireBatEntityIsHurt!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure VampireBatEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((Math.random() < 0.25)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
			sourceentity.attackEntityFrom(DamageSource.GENERIC, (float) 2);
			sourceentity.getPersistentData().putBoolean("isVampire", (true));
			entity.getPersistentData().putDouble("bloodSaturation", 24000);
		}
	}
}
