package me.cockx.geomancermod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class DirtyMineralChunkItem extends ItemBase {
    public DirtyMineralChunkItem(String name) {
        super(name);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if(!worldIn.isRemote&&!playerIn.isSneaking()){
            playerIn.sendMessage(new TextComponentString("The chunk glitters in the palm of your hand. Perhaps you can craft a tool from it?"));
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS,stack);
    }
}
