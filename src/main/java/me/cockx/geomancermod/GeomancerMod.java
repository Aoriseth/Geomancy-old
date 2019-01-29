package me.cockx.geomancermod;

import me.cockx.geomancermod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GeomancerMod.MODID, name = GeomancerMod.NAME, version = GeomancerMod.VERSION)
public class GeomancerMod
{
    public static final String MODID = "geomancermod";
    public static final String NAME = "Geomancy";
    public static final String VERSION = "0.1";

    public static Logger logger;

    @Mod.Instance
    public static GeomancerMod instance;

    @SidedProxy(clientSide = "me.cockx.geomancermod.proxy.ClientProxy",serverSide = "me.cockx.geomancermod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // some example code
        proxy.postInit(event);
        if(Config.printMessage){
            logger.info(Config.yourRealName);
        }
    }
}
