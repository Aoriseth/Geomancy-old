package me.cockx.geomancermod;

import me.cockx.geomancermod.blocks.DregBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("geomancermod:dregblock")
    public static DregBlock dregBlock;

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        dregBlock.initModel();
    }
}
