package personal.gzy.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import personal.gzy.protocol.command.PacketCodeC;

import java.util.List;

/**
 * @ClassName PacketDecoder
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/25 16:31
 * @Version
 **/
public class PacketDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        list.add(PacketCodeC.INSTANCE.decode(byteBuf));
    }
}
