package personal.gzy.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.request.LoginRequestPacket;
import personal.gzy.protocol.command.response.LoginResponsePacket;
import personal.gzy.util.LoginUtil;

import java.util.Date;

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
        if("gzy".equals(loginRequestPacket.getUsername())&&"123456".equals(loginRequestPacket.getPassword())){
            lrp.setSuccess(true);
            LoginUtil.makeAsLogin(channelHandlerContext.channel());
            System.out.println(new Date()+" 客户端登陆成功...");
        }else{
            lrp.setSuccess(false);
            lrp.setReason("用户名或者密码错误...");
            System.err.println(new Date()+" 客户端登陆失败...");
        }
        channelHandlerContext.channel().writeAndFlush(lrp);
    }
}
