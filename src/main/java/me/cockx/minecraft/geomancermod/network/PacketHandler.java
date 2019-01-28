package me.cockx.minecraft.geomancermod.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketHandler {
    private static SimpleNetworkWrapper INSTANCE = null;

    public static void registerMessages(String channel) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channel);
        registerMessages();
    }

    private static void registerMessages() {
        //todo
    }
}
