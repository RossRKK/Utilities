package com.github.rossrkk.utilities.item;

import com.github.rossrkk.utilities.Utilities;
import com.github.rossrkk.utilities.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class ItemOmniToolWood extends ItemTool {
    public EnumToolMaterial material;

    /** an array of the blocks this omnitool is effective against */
    public static Block[] blocksEffectiveAgainst = new Block[] {
            Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab,
            Block.stone, Block.sandStone, Block.cobblestoneMossy,
            Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold,
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice,
            Block.netherrack, Block.oreLapis, Block.blockLapis,
            Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail,
            Block.railDetector, Block.railPowered, Block.grass, Block.dirt,
            Block.sand, Block.gravel, Block.snow, Block.blockSnow,
            Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium,
            Block.planks, Block.bookShelf, Block.wood, Block.chest,
            Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin,
            Block.pumpkinLantern };

    public ItemOmniToolWood(int par1, EnumToolMaterial par2EnumToolMaterial) {
        super(par1, 2, par2EnumToolMaterial, blocksEffectiveAgainst);
        this.setCreativeTab(Utilities.utilTab);
        this.material = par2EnumToolMaterial;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setUnlocalizedName(Strings.OMNI_TOOL_WOOD_NAME);
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block) {
        return par1Block == Block.obsidian ? this.toolMaterial
                .getHarvestLevel() == 3
                : (par1Block != Block.blockDiamond
                        && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald
                        && par1Block != Block.blockEmerald ? (par1Block != Block.blockGold
                        && par1Block != Block.oreGold ? (par1Block != Block.blockIron
                        && par1Block != Block.oreIron ? (par1Block != Block.blockLapis
                        && par1Block != Block.oreLapis ? (par1Block != Block.oreRedstone
                        && par1Block != Block.oreRedstoneGlowing ? (par1Block.blockMaterial == Material.rock ? true
                        : (par1Block.blockMaterial == Material.iron ? true
                                : par1Block.blockMaterial == Material.anvil))
                        : this.toolMaterial.getHarvestLevel() >= 2)
                        : this.toolMaterial.getHarvestLevel() >= 1)
                        : this.toolMaterial.getHarvestLevel() >= 1)
                        : this.toolMaterial.getHarvestLevel() >= 2)
                        : this.toolMaterial.getHarvestLevel() >= 2)
                        : this.toolMaterial.getHarvestLevel() >= 2);
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base,
     * (Quality+1)*2 if correct blocktype, 1.5F if sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
        return par2Block != null
                && (par2Block.blockMaterial == Material.iron
                        || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock) ? this.efficiencyOnProperMaterial
                : super.getStrVsBlock(par1ItemStack, par2Block);
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D() {
        return true;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack,
            ItemStack par2ItemStack) {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true
                : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    // hoing script
    public boolean onItemUse(ItemStack par1ItemStack,
            EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
            int par6, int par7, float par8, float par9, float par10) {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7,
                par1ItemStack)) {
            return false;
        } else {
            int var11 = par3World.getBlockId(par4, par5, par6);
            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

            if ((par7 == 0 || var12 != 0 || var11 != Block.grass.blockID)
                    && var11 != Block.dirt.blockID) {
                return false;
            } else {
                Block var13 = Block.tilledField;
                par3World.playSoundEffect((double) ((float) par4 + 0.5F),
                        (double) ((float) par5 + 0.5F),
                        (double) ((float) par6 + 0.5F),
                        var13.stepSound.getStepSound(),
                        (var13.stepSound.getVolume() + 1.0F) / 2.0F,
                        var13.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote) {
                    return true;
                } else {
                    par3World.setBlock(par4, par5, par6, var13.blockID);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }
    
    @Override
   	@SideOnly(Side.CLIENT)
   	public void registerIcons(IconRegister register) {
   		itemIcon = register.registerIcon(Strings.TEXTURE_LOCATION + ":" + Strings.OMNI_TOOL_WOOD_NAME);
   	}
}