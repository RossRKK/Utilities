package com.github.rossrkk.utilities.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;
import com.github.rossrkk.utilities.tileentities.TEBlockPlacer;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlockPlacer extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private Icon placeIcon;

	protected BlockBlockPlacer(int id, Material material) {
		super(id, material);
		setHardness(3.0F);
		setUnlocalizedName(Strings.BLOCK_PLACER_NAME);
		setCreativeTab(Utilities.utilTab);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof IInventory) {
			IInventory inventory = (IInventory)te;

			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack stack = inventory.getStackInSlotOnClosing(i);

				if (stack != null) {
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();

					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);

					float mult = 0.05F;

					droppedItem.motionX = (-0.5F + world.rand.nextFloat()) * mult;
					droppedItem.motionY = (4 + world.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5F + world.rand.nextFloat()) * mult;

					world.spawnEntityInWorld(droppedItem);
				}
			}
		}

		super.breakBlock(world, x, y, z, id, meta);
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return world.getBlockMetadata(x, y, z) != side;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TEBlockPlacer();
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

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, Utilities.instance, 0, world, x, y, z);
		}
		return true;
	}

	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float par6, float par7, float par8, int par9) {
		world.setBlockMetadataWithNotify(x, y, z, side, 0);
		return side;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_PLACER_NAME);
		placeIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.BLOCK_PLACER_NAME + "Placer");
	}
}
