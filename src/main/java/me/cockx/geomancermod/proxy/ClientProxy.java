package me.cockx.geomancermod.proxy;

import me.cockx.geomancermod.util.ParticlePacket;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        CommonProxy.simpleNetworkWrapper.registerMessage(ParticlePacket.Handler.class,ParticlePacket.class,CommonProxy.SMOKE,Side.CLIENT);

    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void registerItemRenderer(Item item, int metadata, String id) {
        ModelLoader.setCustomModelResourceLocation(item,metadata,new ModelResourceLocation(item.getRegistryName(),id));
    }

}
