package personal.gzy.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.response.LoginResponsePacket;
import personal.gzy.session.Session;
import personal.gzy.util.SessionUtil;

/**
 * @ClassName LoginResponseHandler
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/25 16:07
 * @Version
 **/
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponsePacket) throws Exception {
        if (loginResponsePacket.isSuccess()) {
            System.out.println("客户端登陆成功,用户ID为："+loginResponsePacket.getUserId());
            SessionUtil.bindSession(new Session(loginResponsePacket.getUserId(),
                    loginResponsePacket.getUserName()), channelHandlerContext.channel());
        } else {
            System.out.println("客户端登陆失败,因为:" + loginResponsePacket.getReason());
            channelHandlerContext.channel().close();
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭...");
        super.channelInactive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("LoginResponseHandler.handlerRemoved 被移除...");
        super.handlerRemoved(ctx);
    }
}
