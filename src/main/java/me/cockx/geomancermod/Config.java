package me.cockx.geomancermod;

import me.cockx.geomancermod.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {

    private static final String CATEGORY_GENERAL = "general";
    public static boolean printMessage = true;
    public static String yourRealName = "Steve";

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            GeomancerMod.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        // cfg.getBoolean() will get the value in the config if it is already specified there. If not it will create the value.
        printMessage = cfg.getBoolean("goodTutorial", CATEGORY_GENERAL, printMessage, "Set to false if you don't like this tutorial");
        yourRealName = cfg.getString("realName", CATEGORY_GENERAL, yourRealName, "Set your real name here");
    }
}
