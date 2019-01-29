package me.cockx.geomancermod.blocks;

import me.cockx.geomancermod.GeomancerMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class DregBlock extends Block {

    public DregBlock(){
        super(Material.GROUND);
        setUnlocalizedName(GeomancerMod.MODID+".dregblock");
        setRegistryName("dregblock");
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),0,new ModelResourceLocation(getRegistryName(),"inventory"));
    }
}
