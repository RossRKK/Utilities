package com.github.rossrkk.utilities;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.github.rossrkk.utilities.item.CobbleHolder;
import com.github.rossrkk.utilities.item.ItemOmniTool;
import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.recipes.CopperTransmute;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Utilities {

    // create item instances
    public static Item cobbleHolder;

    // omni tools
    public static Item omnitoolDiamond;
    public static Item omnitoolGold;
    public static Item omnitoolIron;
    public static Item omnitoolStone;
    public static Item omnitoolWood;

    @PreInit
    public void ModsToLoad(FMLPreInitializationEvent event) {
        // Initialise all the items
        cobbleHolder = new CobbleHolder(IDs.COBBLE_HOLDER_ID);

        // Omnitools
        omnitoolDiamond = new ItemOmniTool(IDs.OMNI_TOOL_ID,
                EnumToolMaterial.EMERALD);
        omnitoolGold = new ItemOmniTool(IDs.OMNI_TOOL_ID + 1,
                EnumToolMaterial.GOLD);
        omnitoolIron = new ItemOmniTool(IDs.OMNI_TOOL_ID + 2,
                EnumToolMaterial.IRON);
        omnitoolStone = new ItemOmniTool(IDs.OMNI_TOOL_ID + 3,
                EnumToolMaterial.STONE);
        omnitoolWood = new ItemOmniTool(IDs.OMNI_TOOL_ID + 4,
                EnumToolMaterial.WOOD);
    }

    @Init
    public void load(FMLInitializationEvent event) {

    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        // load EE3 Modules
        CopperTransmute.init();
    }

    // register items in game
    public static void gameRegisters() {
        GameRegistry.registerItem(cobbleHolder, Strings.COBBLE_HOLDER_NAME,
                Reference.MOD_ID);

        // Omnitools
        GameRegistry.registerItem(omnitoolDiamond, Strings.OMNI_TOOL_NAME,
                Reference.MOD_ID);
        GameRegistry.registerItem(omnitoolGold, Strings.OMNI_TOOL_NAME,
                Reference.MOD_ID);
        GameRegistry.registerItem(omnitoolIron, Strings.OMNI_TOOL_NAME,
                Reference.MOD_ID);
        GameRegistry.registerItem(omnitoolStone, Strings.OMNI_TOOL_NAME,
                Reference.MOD_ID);
        GameRegistry.registerItem(omnitoolWood, Strings.OMNI_TOOL_NAME,
                Reference.MOD_ID);

        // Crafting Recipes

        // Omni tool recipes
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolDiamond, 1),
                Item.axeDiamond, Item.pickaxeDiamond, Item.hoeDiamond,
                Item.shovelDiamond, Item.swordDiamond);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolGold, 1),
                Item.axeGold, Item.pickaxeGold, Item.hoeGold, Item.shovelGold,
                Item.swordGold);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolIron, 1),
                Item.axeIron, Item.pickaxeIron, Item.hoeIron, Item.shovelIron,
                Item.swordIron);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolStone, 1),
                Item.axeStone, Item.pickaxeStone, Item.hoeStone,
                Item.shovelStone, Item.swordStone);
        GameRegistry.addShapelessRecipe(new ItemStack(omnitoolWood, 1),
                Item.axeWood, Item.pickaxeWood, Item.hoeWood, Item.shovelWood,
                Item.swordWood);

        // Smelting Recipes

        // rotten flesh --> leather
        GameRegistry.addSmelting(111, new ItemStack(Item.leather, 1), 1);
    }

    public static void langugeRegisters() {
        LanguageRegistry.addName(cobbleHolder, "Cobble Holder");

        // Omnitools
        LanguageRegistry.addName(omnitoolDiamond, "Omni Tool");
        LanguageRegistry.addName(omnitoolGold, "Omni Tool");
        LanguageRegistry.addName(omnitoolIron, "Omni Tool");
        LanguageRegistry.addName(omnitoolStone, "Omni Tool");
        LanguageRegistry.addName(omnitoolWood, "Omni Tool");
    }
}