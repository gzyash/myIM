package personal.gzy.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import personal.gzy.protocol.command.Packet;
import personal.gzy.protocol.command.PacketCodeC;

/**
 * @ClassName PacketEncoder
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/25 16:28
 * @Version
 **/
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        PacketCodeC.INSTANCE.encode(byteBuf, packet);
    }
}
