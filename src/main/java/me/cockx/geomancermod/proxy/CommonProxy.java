package me.cockx.geomancermod.proxy;

import me.cockx.geomancermod.Config;
import me.cockx.geomancermod.ModRecipes;
import me.cockx.geomancermod.blocks.BlockBase;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }

    public void registerItemRenderer(Item item, int metadata, String id) { }
}
