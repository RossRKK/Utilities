package com.github.rossrkk.utilities.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.github.rossrkk.utilities.lib.Reference;
import com.pahimar.ee3.core.util.RecipeHelper;
import java.util.ArrayList;

public class CopperTransmute {

    public static void init() {
        try {
            for (ItemStack stone : Reference.TRANSMUTATION_STONES) {
                copper(stone);
                tin(stone);
                silver(stone);
            }
        } catch (Exception e) {/* Swallowed */
        }

    }

    public static void tin(ItemStack transmutationStone) {
        try {
            ArrayList<ItemStack> tinOres = OreDictionary.getOres("ingotTin");
            ItemStack tinItemStack = tinOres.get(0);
            tinItemStack.stackSize = 3;
            Item tinItem = tinItemStack.getItem();
            RecipeHelper.addRecipe(tinItemStack, transmutationStone,
                    Item.ingotIron, Item.ingotIron, Item.ingotIron);
            RecipeHelper.addRecipe(new ItemStack(Item.ingotIron, 1),
                    transmutationStone, tinItem);
        } catch (Exception e) {/* Swallowed */
        }
    }

    public static void silver(ItemStack transmutationStone) {
        try {
            ArrayList<ItemStack> silverOres = OreDictionary
                    .getOres("ingotSilver");
            ItemStack silverItemStack = silverOres.get(0);
            silverItemStack.stackSize = 2;
            Item silverItem = silverItemStack.getItem();
            RecipeHelper.addRecipe(silverItemStack, transmutationStone,
                    Item.ingotGold, Item.ingotGold);
            RecipeHelper.addRecipe(new ItemStack(Item.ingotGold, 1),
                    transmutationStone, silverItem);
        } catch (Exception e) {/* Swallowed */
        }
    }

    public static void copper(ItemStack transmutationStone) {
        try {
            ArrayList<ItemStack> copperOres = OreDictionary
                    .getOres("ingotCopper");
            ItemStack copperItemStack = copperOres.get(0);
            copperItemStack.stackSize = 2;
            Item copperItem = copperItemStack.getItem();
            RecipeHelper.addRecipe(copperItemStack, transmutationStone,
                    Item.ingotIron, Item.ingotIron);
            RecipeHelper.addRecipe(new ItemStack(Item.ingotIron, 1),
                    transmutationStone, copperItem);
        } catch (Exception e) {/* Swallowed */
        }
    }
}