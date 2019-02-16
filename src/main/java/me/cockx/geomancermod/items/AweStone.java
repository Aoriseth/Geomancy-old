package me.cockx.geomancermod.items;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public class AweStone extends ItemBase {
    public AweStone(String name) {
        super(name);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn) {

        if(!worldIn.isRemote){
            BlockPos position = playerIn.getPosition();
            AxisAlignedBB axisAlignedBB = new AxisAlignedBB(position).grow(50d);
            List<EntityCreature> entitiesWithinAABB = worldIn.getEntitiesWithinAABB(EntityCreature.class, axisAlignedBB);

            for (EntityCreature creature:entitiesWithinAABB){
                creature.attemptTeleport(position.getX(),position.getY(),position.getZ());
            }
        }


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
