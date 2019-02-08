package me.cockx.geomancermod.proxy;

import me.cockx.geomancermod.Config;
import me.cockx.geomancermod.ModRecipes;
import me.cockx.geomancermod.handlers.MainCompatHandler;
import me.cockx.geomancermod.handlers.ServerHandlerDummy;
import me.cockx.geomancermod.util.ParticlePacket;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    static final byte SMOKE = 88;
    public static SimpleNetworkWrapper simpleNetworkWrapper;


    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        File directory = event.getSuggestedConfigurationFile();
        config = new Configuration(directory);
        Config.readConfig();
        MainCompatHandler.registerTOP();
        simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("ParticleEffects");
        simpleNetworkWrapper.registerMessage(ServerHandlerDummy.class, ParticlePacket.class,SMOKE, Side.SERVER);
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
