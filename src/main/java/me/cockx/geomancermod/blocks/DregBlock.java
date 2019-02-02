package me.cockx.geomancermod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class DregBlock extends BlockBase {
    public DregBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.GROUND);
        setHardness(0.2F);
        setResistance(15F);
        setHarvestLevel("shovel",1);
        setLightLevel(1f);
//        setLightOpacity(0);
//        setBlockUnbreakable();
    }
}
