package me.cockx.geomancermod.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class ContainerConcept extends Container {

    private ContainerTileEntity containerTileEntity;

    public ContainerConcept(IInventory playerInventory, ContainerTileEntity tileEntity) {
        this.containerTileEntity = tileEntity;
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        for (int row=0;row<3;++row){
            for (int col=0;col<9;++col){
                int x = 9+col*18;
                int y = row*18+70;
                this.addSlotToContainer(new Slot(playerInventory,col+row*9+10,x,y));
            }
        }

        for (int row=0;row<9;++row){
            int x = 9+row*18;
            int y = 58+70;
            this.addSlotToContainer(new Slot(playerInventory,row,x,y));
        }
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = this.containerTileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,null);
        int x = 9;
        int y = 6;

        int slotIndex = 0;
        if (itemHandler != null) {
            for (int i = 0;i<itemHandler.getSlots();i++){
                addSlotToContainer(new SlotItemHandler(itemHandler,slotIndex,x,y));
                slotIndex++;
                x+=18;
            }
        }
    }

    @Override
    public boolean canInteractWith(@Nonnull EntityPlayer entityPlayer) {
        return containerTileEntity.canInteractWith(entityPlayer);
    }

    @Override
    @Nonnull
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < ContainerTileEntity.SIZE) {
                if (!this.mergeItemStack(itemStack1, ContainerTileEntity.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, ContainerTileEntity.SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

}
