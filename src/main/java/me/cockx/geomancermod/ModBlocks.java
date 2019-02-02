package me.cockx.geomancermod;

import me.cockx.geomancermod.blocks.BlockBase;
import me.cockx.geomancermod.blocks.DregBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCK_LIST = new ArrayList<>();

    public static final Block DREG = new BlockBase("dreg", Material.GROUND);
    public static final Block SOFTDREG = new DregBlock("softdreg",Material.GROUND);
}
