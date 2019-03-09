package me.cockx.geomancermod.proxy;

import me.cockx.geomancermod.blocks.ContainerConcept;
import me.cockx.geomancermod.blocks.ContainerGui;
import me.cockx.geomancermod.blocks.ContainerTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiProxy implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int i, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ContainerTileEntity) {
            return new ContainerConcept(entityPlayer.inventory, (ContainerTileEntity) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int i, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ContainerTileEntity) {
            ContainerTileEntity containerTileEntity = (ContainerTileEntity) te;
            return new ContainerGui(containerTileEntity, new ContainerConcept(entityPlayer.inventory, containerTileEntity));
        }
        return null;
    }
}
