package me.cockx.minecraft.geomancermod.proxy;


import me.cockx.minecraft.geomancermod.Config;
import me.cockx.minecraft.geomancermod.GeomancerMod;
import me.cockx.minecraft.geomancermod.ModDimensions;
import me.cockx.minecraft.geomancermod.ModEntities;
import me.cockx.minecraft.geomancermod.items.MushItem;
import me.cockx.minecraft.geomancermod.network.PacketHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e){
        File directory = e.getModConfigurationDirectory();
        config = new Configuration(directory,"geomancy.cfg");
        Config.readConfig();

        PacketHandler.registerMessages("geomancermod");

        ModEntities.init();
        ModDimensions.init();

        //todo
//        MainCompatHandler.registerWaila();
//        MainCompatHandler.registerTOP();
    }

    public void init(FMLInitializationEvent e){
        NetworkRegistry.INSTANCE.registerGuiHandler(GeomancerMod.instance,new GuiProxy());
    }

    public void postInit(FMLPostInitializationEvent e){
        if(config.hasChanged()){
            config.save();
        }
    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(new MushItem());
    }



}
