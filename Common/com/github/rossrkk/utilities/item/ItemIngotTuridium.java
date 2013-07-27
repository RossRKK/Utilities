package com.github.rossrkk.utilities.item;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemIngotTuridium extends Item {

	public ItemIngotTuridium(int id) {
		super(id);
		setUnlocalizedName(Strings.INGOT_TURIDIUM_NAME);
        this.setCreativeTab(Utilities.utilTab);
	}
	
    @Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.INGOT_TURIDIUM_NAME);
    }
}
