package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.power.Power;
import com.github.rossrkk.utilities.tileentities.TECable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCable extends BlockContainer {

	public BlockCable(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Strings.CABLE_NAME);
		setCreativeTab(Utilities.utilTab);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TECable();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
		Power te = (Power)world.getBlockTileEntity(x, y, z);
		player.addChatMessage("Power Level is:  " + te.getPower());
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.CABLE_NAME);
	}
}
