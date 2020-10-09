package net.mcreator.halloween.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;

@HalloweenModElements.ModElement.Tag
public class WendigoThisEntityKillsAnotherOneProcedure extends HalloweenModElements.ModElement {
	public WendigoThisEntityKillsAnotherOneProcedure(HalloweenModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure WendigoThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WendigoThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WendigoThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WendigoThisEntityKillsAnotherOne!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WendigoThisEntityKillsAnotherOne!");
			return;
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (sourceentity instanceof LivingEntity)
			((LivingEntity) sourceentity).setHealth(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) + 10f);
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.HEART, x, y, z, (int) 5, 2, 2, 2, 1);
		}
	}
}
