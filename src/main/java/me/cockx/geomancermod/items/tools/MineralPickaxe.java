package me.cockx.geomancermod.items.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MineralPickaxe extends ToolPickaxe {
    public MineralPickaxe(String name, ToolMaterial material) {
        super(name, material);
    }

    @Override
    public boolean onBlockDestroyed(@Nonnull ItemStack stack, World worldIn, @Nonnull IBlockState state, @Nonnull BlockPos pos, @Nonnull EntityLivingBase entityLiving) {
        if(!worldIn.isRemote){
            entityLiving.sendMessage(new TextComponentString(state.getBlock().getUnlocalizedName()));
        }

        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
