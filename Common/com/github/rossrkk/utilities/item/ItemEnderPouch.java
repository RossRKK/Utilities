package com.github.rossrkk.utilities.item;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderPouch extends Item{

	public ItemEnderPouch(int id) {
		super(id);
		maxStackSize = 1;
		setUnlocalizedName(Strings.ENDER_POUCH_NAME);
		setCreativeTab(Utilities.utilTab);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world,
            EntityPlayer player) {
		player.displayGUIChest(player.getInventoryEnderChest());
		return itemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.ENDER_POUCH_NAME);
	}
}
