package me.cockx.geomancermod.blocks;

import me.cockx.geomancermod.GeomancerMod;
import me.cockx.geomancermod.ModBlocks;
import me.cockx.geomancermod.ModItems;
import me.cockx.geomancermod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {
        super(material);
        setUnlocalizedName(GeomancerMod.MODID+"."+name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.BLOCK_LIST.add(this);
        ModItems.ITEM_LIST.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        GeomancerMod.proxy.registerItemRenderer(Item.getItemFromBlock(this),0,"inventory");
    }
}
