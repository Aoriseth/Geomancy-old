package me.cockx.geomancermod.items.tools;

import me.cockx.geomancermod.ModItems;
import me.cockx.geomancermod.proxy.CommonProxy;
import me.cockx.geomancermod.util.ParticlePacket;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;

import javax.annotation.Nonnull;

public class MineralPickaxe extends ToolPickaxe {
    public MineralPickaxe(String name, ToolMaterial material) {
        super(name, material);
    }

    @Override
    public boolean onBlockDestroyed(@Nonnull ItemStack stack, World worldIn, @Nonnull IBlockState state, @Nonnull BlockPos pos, @Nonnull EntityLivingBase entityLiving) {

            if(state.getBlock().getUnlocalizedName().equals(Blocks.STONE.getUnlocalizedName())){
                if(Math.random()>=0.5){
                    if(!worldIn.isRemote){
                        worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),new ItemStack(ModItems.MINERAL_CHUNK,1)));
                        worldIn.playSound(null,pos.getX(),pos.getY(),pos.getZ(),SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,SoundCategory.AMBIENT,1f,1f);

                        ParticlePacket particlePacket = new ParticlePacket(pos.getX(), pos.getY(), pos.getZ());
                        TargetPoint target = new TargetPoint(worldIn.provider.getDimension(), pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ() + 0.5D, 20.d);
                        CommonProxy.simpleNetworkWrapper.sendToAllAround(particlePacket, target);
                    }
                }
            }

        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}
