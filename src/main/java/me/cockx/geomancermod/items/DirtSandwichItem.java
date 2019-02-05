package me.cockx.geomancermod.items;

import me.cockx.geomancermod.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class DirtSandwichItem extends FoodItemBase {
    public DirtSandwichItem(String name, int amount, float saturation, boolean isWolfFood) {
        super(name, amount, saturation, isWolfFood);
        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, @Nonnull EntityPlayer player) {
        if(!worldIn.isRemote){
            player.sendMessage(new TextComponentString("*Crunch* Eeeew. There was a small item embedded in the dirt."));
            Vec3d lookVec = player.getLookVec();
            EntityItem item = new EntityItem(worldIn,player.posX+lookVec.x*3,player.posY,player.posZ+lookVec.z*3,new ItemStack(ModItems.DIRTY_MINERAL_CHUNK,1));
            worldIn.spawnEntity(item);
//            ItemStack itemStack = new ItemStack(ModItems.MINERAL_CHUNK, 1);
//            player.addItemStackToInventory(itemStack);
//            player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND,itemStack.copy());
//            player.setItemStackToSlot();
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
