package me.cockx.geomancermod.items;

import me.cockx.geomancermod.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class Trock extends ItemBase {
    public Trock(String name) {
        super(name);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {

        if(!worldIn.isRemote){
            BlockPos position = playerIn.getPosition();
            position = position.down().south().west();

            for (int i = 0; i <3; i++) {
                for (int j = 0; j < 3; j++) {
                    BlockPos newpos = position.east(i);
                    newpos = newpos.north(j);
                    if (worldIn.getBlockState(newpos).getBlock().equals(Blocks.AIR)){
                        worldIn.setBlockState(newpos, ModBlocks.AEROSAND.getDefaultState());
                    }

                }
            }

        }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
