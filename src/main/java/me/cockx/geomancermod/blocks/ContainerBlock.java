package me.cockx.geomancermod.blocks;

import me.cockx.geomancermod.GeomancerMod;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ContainerBlock extends BlockBase implements ITileEntityProvider {

    private static final int GUI_ID = 1;

    public ContainerBlock(String name, Material material) {
        super(name, material);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(@Nonnull World world, int i) {
        return new ContainerTileEntity();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote){
            return true;
        }
        TileEntity te = worldIn.getTileEntity(pos);
        if (!(te instanceof ContainerTileEntity)){
            return false;
        }
        playerIn.openGui(GeomancerMod.instance,GUI_ID,worldIn,pos.getX(),pos.getY(),pos.getZ());
        return true;
    }
}
