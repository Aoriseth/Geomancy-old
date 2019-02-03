package me.cockx.geomancermod.items;

import me.cockx.geomancermod.GeomancerMod;
import me.cockx.geomancermod.ModItems;
import me.cockx.geomancermod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FoodItemBase extends ItemFood implements IHasModel {

    public FoodItemBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
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
