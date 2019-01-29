package me.cockx.geomancermod.items;

import me.cockx.geomancermod.GeomancerMod;
import me.cockx.geomancermod.ModItems;
import me.cockx.geomancermod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {
        setUnlocalizedName(GeomancerMod.MODID+"."+name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEM_LIST.add(this);
    }

    @Override
    public void registerModels() {
        GeomancerMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
