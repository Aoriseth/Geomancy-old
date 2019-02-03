package me.cockx.geomancermod.items.tools;

import me.cockx.geomancermod.GeomancerMod;
import me.cockx.geomancermod.ModItems;
import me.cockx.geomancermod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {
    public ToolSword(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(GeomancerMod.MODID+"."+name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
        ModItems.ITEM_LIST.add(this);
    }

    @Override
    public void registerModels() {
        GeomancerMod.proxy.registerItemRenderer(this,0,"inventory");
    }
}
