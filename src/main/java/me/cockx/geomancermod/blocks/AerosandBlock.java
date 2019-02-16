package me.cockx.geomancermod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AerosandBlock extends BlockBase {
    public AerosandBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.GROUND);
        setHardness(0F);
        setResistance(0F);
        setHarvestLevel("shovel",0);
        setLightLevel(0f);
        setLightOpacity(2);
//        setBlockUnbreakable();
    }
}
