package me.cockx.geomancermod.handlers;

import me.cockx.geomancermod.util.TopCompatibility;
import net.minecraftforge.fml.common.Loader;

public class MainCompatHandler {

    public static void registerTOP(){
        if ( Loader.isModLoaded("theoneprobe")){
            TopCompatibility.register();
        }
    }
}
