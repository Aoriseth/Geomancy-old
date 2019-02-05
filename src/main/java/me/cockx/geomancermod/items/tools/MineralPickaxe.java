package me.cockx.geomancermod.items.tools;

import me.cockx.geomancermod.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MineralPickaxe extends ToolPickaxe {
    public MineralPickaxe(String name, ToolMaterial material) {
        super(name, material);
    }

    @Override
    public boolean onBlockDestroyed(@Nonnull ItemStack stack, World worldIn, @Nonnull IBlockState state, @Nonnull BlockPos pos, @Nonnull EntityLivingBase entityLiving) {
        if(!worldIn.isRemote){
            if(state.getBlock().getUnlocalizedName().equals(Blocks.STONE.getUnlocalizedName())){
                if(Math.random()>=0){
                    worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(ModItems.MINERAL_CHUNK,1)));
                    worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE,pos.getX(),pos.getY(),pos.getZ(),1,1,1);
                    worldIn.playSound(pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+0.5, SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.BLOCKS,1.0f,1.0f,false);
                }
            }


        }

        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
