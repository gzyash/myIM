package personal.gzy.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.response.MessageResponsePacket;

/**
 * @ClassName MessageResponseHandler
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/25 16:09
 * @Version
 **/
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {
        System.out.println(messageResponsePacket.getFromUserId()+" : "+messageResponsePacket.getFromUserName()+
                            " -> "+messageResponsePacket.getMessage());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MessageResponseHandler.handlerRemoved 被移除...");
        super.handlerRemoved(ctx);
    }
}
