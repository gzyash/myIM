package personal.gzy.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import personal.gzy.client.handler.LoginResponseHandler;
import personal.gzy.protocol.command.request.LoginOutRequestPacket;
import personal.gzy.protocol.command.response.LoginOutResponsePacket;
import personal.gzy.util.SessionUtil;

public class LoginOutReqestHandler extends SimpleChannelInboundHandler<LoginOutRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginOutRequestPacket msg) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
        LoginOutResponsePacket loginOutResponsePacket = new LoginOutResponsePacket();
        loginOutResponsePacket.setReason("");
        loginOutResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(loginOutResponsePacket);
    }
}
