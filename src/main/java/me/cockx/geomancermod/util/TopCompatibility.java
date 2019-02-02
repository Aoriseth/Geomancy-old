package me.cockx.geomancermod.util;

import mcjty.theoneprobe.api.*;
import me.cockx.geomancermod.GeomancerMod;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import org.apache.logging.log4j.Level;

import javax.annotation.Nullable;
import java.util.function.Function;

public class TopCompatibility {

    private static boolean registered;

    public static void register(){
        if(registered){
            return;
        }
        registered = true;
        FMLInterModComms.sendFunctionMessage("theoneprobe","getTheOneProbe","mcjty.modtut.compat.top.TOPCompatibility$GetTheOneProbe");
    }

    @SuppressWarnings("unused")
    private static class GetTheOneProbe implements Function<ITheOneProbe,Void>{

        static ITheOneProbe probe;

        @Nullable
        @Override
        public Void apply(ITheOneProbe theOneProbe) {
            probe = theOneProbe;

            GeomancerMod.logger.log(Level.INFO,"Enabled support for The One Probe");
            probe.registerProvider(new IProbeInfoProvider() {
                @Override
                public String getID() {
                    return "geomancermod:default";
                }

                @Override
                public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
                    if(blockState.getBlock() instanceof TopInfoProvider){
                        TopInfoProvider provider = (TopInfoProvider) blockState.getBlock();
                        provider.addProbeInfo(mode,probeInfo,player,world,blockState,data);
                    }
                }
            });

            return null;
        }
    }

}
