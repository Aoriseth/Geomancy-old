package me.cockx.minecraft.geomancermod.items;

import me.cockx.minecraft.geomancermod.GeomancerMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MushItem extends Item {

    public MushItem() {
        setRegistryName("mushitem");
        setUnlocalizedName(GeomancerMod.MODID + ".mushitem");

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this,0,new ModelResourceLocation(getRegistryName(),"inventory"));
    }
}
