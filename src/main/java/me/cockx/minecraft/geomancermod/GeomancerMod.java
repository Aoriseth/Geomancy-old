package me.cockx.minecraft.geomancermod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GeomancerMod.MODID, name = GeomancerMod.NAME, version = GeomancerMod.VERSION)
public class GeomancerMod
{
    public static final String MODID = "geomancermod";
    public static final String NAME = "Geomancy";
    public static final String VERSION = "0.1";

    private static Logger logger;

    @Mod.Instance
    public static GeomancerMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
