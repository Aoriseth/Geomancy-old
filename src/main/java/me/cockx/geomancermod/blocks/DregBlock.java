package me.cockx.geomancermod.blocks;

import me.cockx.geomancermod.GeomancerMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class DregBlock extends Block {

    public DregBlock(){
        super(Material.GROUND);
        setUnlocalizedName(GeomancerMod.MODID+".dregblock");
        setRegistryName("dregblock");
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}
