package personal.gzy.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.request.MessageRequestPacket;
import personal.gzy.protocol.command.response.MessageResponsePacket;

import java.util.Date;

/**
 * @ClassName MessageRequestHandler
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/25 16:17
 * @Version
 **/
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageRequestPacket messageRequestPacket) throws Exception {
        System.out.println(new Date()+"  收到客户端信息："+messageRequestPacket.getMessage());
        MessageResponsePacket mrp = new MessageResponsePacket();
        mrp.setMessage("服务端回复【"+messageRequestPacket.getMessage()+"】");
        channelHandlerContext.channel().writeAndFlush(mrp);
    }
}
