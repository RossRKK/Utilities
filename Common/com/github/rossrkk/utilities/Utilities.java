package com.github.rossrkk.utilities;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import com.github.rossrkk.utilities.item.CobbleHolder;
import com.github.rossrkk.utilities.item.ItemOmniToolDiamond;
import com.github.rossrkk.utilities.item.ItemOmniToolGold;
import com.github.rossrkk.utilities.item.ItemOmniToolIron;
import com.github.rossrkk.utilities.item.ItemOmniToolStone;
import com.github.rossrkk.utilities.item.ItemOmniToolWood;
import com.github.rossrkk.utilities.item.Items;
import com.github.rossrkk.utilities.lib.IDs;
import com.github.rossrkk.utilities.lib.Reference;
import com.github.rossrkk.utilities.lib.Strings;

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


    @PreInit
    public void ModsToLoad(FMLPreInitializationEvent event) {
    	
    	ConfigLoader.init(event.getSuggestedConfigurationFile());
    	
        Items.init();
    }

    @Init
    public void load(FMLInitializationEvent event) {
    	
    }

    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
    }
}