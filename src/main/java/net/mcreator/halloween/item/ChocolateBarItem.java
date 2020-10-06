
package net.mcreator.halloween.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.halloween.procedures.ChocolateBarItemIsCraftedsmeltedProcedure;
import net.mcreator.halloween.HalloweenModElements;

import java.util.Map;
import java.util.HashMap;

@HalloweenModElements.ModElement.Tag
public class ChocolateBarItem extends HalloweenModElements.ModElement {
	@ObjectHolder("halloween:chocolate_bar")
	public static final Item block = null;
	public ChocolateBarItem(HalloweenModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(1).saturation(0.2f).build()));
			setRegistryName("chocolate_bar");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ChocolateBarItemIsCraftedsmeltedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
