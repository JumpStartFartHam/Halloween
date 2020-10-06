
package net.mcreator.halloween.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.block.Blocks;

import net.mcreator.halloween.HalloweenModElements;

@HalloweenModElements.ModElement.Tag
public class PumpkinPickaxeItem extends HalloweenModElements.ModElement {
	@ObjectHolder("halloween:pumpkin_pickaxe")
	public static final Item block = null;
	public PumpkinPickaxeItem(HalloweenModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 118;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.PUMPKIN, (int) (1)));
			}
		}, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("pumpkin_pickaxe"));
	}
}
