package com.github.rossrkk.utilities.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockJumpPad extends Block {


	public BlockJumpPad(int id, Material material) {
		super(id, material);
		setUnlocalizedName(Strings.JUMP_PAD_NAME);
		setHardness(4.0F);
		setCreativeTab(Utilities.utilTab);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
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
		int meta = world.getBlockMetadata(x, y, z);
		if (!player.isSneaking()) {
			if (meta < 16) {
				world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
				return true;
			}
		} else {
			if (meta > 0) {
				world.setBlockMetadataWithNotify(x, y, z, meta - 1, 2);
				return true;
			}
		}
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.fallDistance = 0;
		if (entity instanceof EntityLivingBase) {
			if (!entity.isSneaking()) {
				entity.motionY += Math.sqrt(world.getBlockMetadata(x, y, z)) + 0.1;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		blockIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.JUMP_PAD_NAME);
	}
}
