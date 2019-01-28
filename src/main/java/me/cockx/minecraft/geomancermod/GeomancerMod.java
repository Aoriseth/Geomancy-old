package me.cockx.minecraft.geomancermod;

import me.cockx.minecraft.geomancermod.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GeomancerMod.MODID, name = GeomancerMod.NAME, version = GeomancerMod.VERSION)
public class GeomancerMod {

    public static final String MODID = "geomancermod";
    public static final String NAME = "Geomancy";
    public static final String VERSION = "0.1";

    private static Logger logger;

    @SidedProxy(clientSide = "me.cockx.minecraft.geomancermod.proxy.ClientProxy", serverSide = "me.cockx.minecraft.geomancermod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static GeomancerMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

    }
}
