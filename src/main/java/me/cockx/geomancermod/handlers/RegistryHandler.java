package me.cockx.geomancermod.handlers;

import me.cockx.geomancermod.ModBlocks;
import me.cockx.geomancermod.ModItems;
import me.cockx.geomancermod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ModItems.ITEM_LIST.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(ModBlocks.BLOCK_LIST.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for (Item item:ModItems.ITEM_LIST){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModels();
            }
        }
        for (Block block:ModBlocks.BLOCK_LIST){
            if(block instanceof IHasModel){
                ((IHasModel)block).registerModels();
            }
        }
    }

}
