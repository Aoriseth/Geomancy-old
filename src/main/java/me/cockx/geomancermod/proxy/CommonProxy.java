package me.cockx.geomancermod.proxy;

import me.cockx.geomancermod.Config;
import me.cockx.geomancermod.ModBlocks;
import me.cockx.geomancermod.blocks.DregBlock;
import me.cockx.geomancermod.items.MushItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getSuggestedConfigurationFile();
        config = new Configuration(directory);
        Config.readConfig();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().register(new DregBlock());

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(new ItemBlock(ModBlocks.dregBlock).setRegistryName(ModBlocks.dregBlock.getRegistryName()));
        event.getRegistry().register(new MushItem());

    }




}
