package personal.gzy.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.request.LoginRequestPacket;
import personal.gzy.protocol.command.response.LoginResponsePacket;
import personal.gzy.session.Session;
import personal.gzy.util.SessionUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @ClassName LoginReqeustHandler
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/25 16:16
 * @Version
 **/
public class LoginReqeustHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket lrp = new LoginResponsePacket();
        lrp.setUserName(loginRequestPacket.getUsername());
        if(validate(loginRequestPacket)){
            lrp.setSuccess(true);
            String userId = randomUserId();
            lrp.setUserId(userId);
            System.out.println(new Date()+" 客户端[ "+ loginRequestPacket.getUsername() +" ]登陆成功...");
            SessionUtil.bindSession(new Session(userId,loginRequestPacket.getUsername()),channelHandlerContext.channel());
        }else{
            lrp.setSuccess(false);
            lrp.setReason("用户名或者密码错误...");
            System.err.println(new Date()+" 客户端登陆失败...");
        }
        channelHandlerContext.channel().writeAndFlush(lrp);
    }

    private String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    private boolean validate(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}
