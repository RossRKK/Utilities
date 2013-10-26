package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.power.IPower;
import com.github.rossrkk.utilities.tileentities.TEBattery;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBattery extends BlockContainer {

	public BlockBattery(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Strings.BATTERY_NAME);
		setHardness(4.0F);
		setCreativeTab(Utilities.utilTab);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
		if (player.isSneaking()) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 1, 2);
			} else {
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
			}
		} else {
			IPower te = (IPower)world.getBlockTileEntity(x, y, z);
			player.addChatMessage("Power Level is:  " + te.getPower());
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEBattery();
	}

	@SideOnly(Side.CLIENT)
	public Icon out;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BATTERY_NAME + "In");
		out = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BATTERY_NAME + "Out");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (meta == 0) {
			return blockIcon;
		}
		return out;
	}
}
