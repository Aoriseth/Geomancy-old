package me.cockx.minecraft.geomancermod;


import me.cockx.minecraft.geomancermod.items.MushItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder("geomancermod:mushitem")
    public static MushItem mushItem;

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        mushItem.initModel();
    }
}
