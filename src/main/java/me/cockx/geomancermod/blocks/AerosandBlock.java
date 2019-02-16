package me.cockx.geomancermod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;

public class AerosandBlock extends BlockBase {
    public AerosandBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.GROUND);
        setHardness(0F);
        setResistance(0F);
        setHarvestLevel("shovel",0);
        setLightLevel(0f);
        setLightOpacity(2);

    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.scheduleBlockUpdate(pos,this,80+new Random().nextInt(40),0);
        super.onBlockAdded(worldIn, pos, state);
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    @Nonnull
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        worldIn.destroyBlock(pos,false);
    }
}
