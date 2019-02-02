package me.cockx.geomancermod;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModItems.MUSH,new ItemStack(ModItems.CHARRED_MUSH,1),0f);
        GameRegistry.addSmelting(Blocks.DIRT,new ItemStack(ModBlocks.DREG,1),0f);
    }
}
