package personal.gzy.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.request.MessageRequestPacket;
import personal.gzy.protocol.command.response.MessageResponsePacket;
import personal.gzy.session.Session;
import personal.gzy.util.SessionUtil;

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
        //拿到发送方的session
        Session session = SessionUtil.getSession(channelHandlerContext.channel());
        MessageResponsePacket mrp = new MessageResponsePacket();
        mrp.setFromUserId(session.getUserId());
        mrp.setFromUserName(session.getUserName());
        mrp.setMessage(messageRequestPacket.getMessage());
        Channel channel = SessionUtil.getChannel(messageRequestPacket.getToUserId());
        if(channel!=null && SessionUtil.hasLogin(channel)){
            channel.writeAndFlush(mrp);
        }else{
            System.out.println("当前用户[ "+messageRequestPacket.getToUserId()+" ]没在线...");
        }
    }
}
