package com.github.rossrkk.utilities.block;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TEBlockBreaker;
import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBlockPlacer extends BlockContainer {
	public static TileEntity tileEnt;

	protected BlockBlockPlacer(int id, Material material) {
		super(id, material);
		setHardness(3.0F);
		setUnlocalizedName(Strings.BLOCK_PLACER_NAME);
		setCreativeTab(Utilities.utilTab);
	}
	
	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return world.getBlockMetadata(x, y, z) != side;
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float par6, float par7, float par8, int par9) {
		world.setBlockMetadataWithNotify(x, y, z, side, 0);
		return side;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		tileEnt = new TEBlockPlacer();
		return tileEnt;
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
		try {
			if (!(tileEnt instanceof IInventory)) {
	            return;
			} else {
	        IInventory inventory = (IInventory) tileEnt;
	        
			EntityItem entityItem = new EntityItem(world, x, y, z, inventory.getStackInSlot(0));
			}
		} catch (NullPointerException e) {}
	}
	
	@SideOnly(Side.CLIENT)
	private Icon placeIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_PLACER_NAME);
		placeIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_PLACER_NAME + "Place");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (meta == side) {
			return placeIcon;
		} else {
			return blockIcon;
		}
	}
}
