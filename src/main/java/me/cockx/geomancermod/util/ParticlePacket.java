package me.cockx.geomancermod.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ParticlePacket implements IMessage {

    private boolean messageValid;
    private double x, y, z;

    public ParticlePacket() {
        this.messageValid = false;
    }

    public ParticlePacket(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.messageValid = true;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        try
        {
            this.x = buf.readDouble();
            this.y = buf.readDouble();
            this.z = buf.readDouble();
        }
        catch(IndexOutOfBoundsException ignored)
        {
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        if(!this.messageValid)
			return;

		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
    }

    public static class Handler implements IMessageHandler<ParticlePacket, IMessage>
    {

        @Override
        public IMessage onMessage(ParticlePacket message, MessageContext ctx)
        {
            if(!message.messageValid && ctx.side != Side.CLIENT) { return null; }

            Minecraft minecraft = Minecraft.getMinecraft();
            final WorldClient worldClient = minecraft.world;
            minecraft.addScheduledTask(() -> processMessage(message, worldClient));
            return null;
        }

        void processMessage(ParticlePacket message, WorldClient worldClient)
        {
            worldClient.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, message.x + 0.5D, message.y + 1.0D, message.z + 0.5D, 0.0D, 0.0D, 0.0D);
        }

    }
}
