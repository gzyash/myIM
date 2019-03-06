package personal.gzy.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.response.LoginOutResponsePacket;
import personal.gzy.util.SessionUtil;

public class LoginOutResponseHandler extends SimpleChannelInboundHandler<LoginOutResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginOutResponsePacket msg) throws Exception {
        if(msg.isSuccess()){
            System.out.println("已退出...");
            SessionUtil.unBindSession(ctx.channel());
        }else{
            System.out.println("退出失败，因为"+msg.getReason());
        }
    }
}
