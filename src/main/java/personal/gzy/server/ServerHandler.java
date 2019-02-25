package personal.gzy.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import personal.gzy.protocol.command.Packet;
import personal.gzy.protocol.command.PacketCodeC;
import personal.gzy.protocol.command.request.LoginRequestPacket;
import personal.gzy.protocol.command.request.MessageRequestPacket;
import personal.gzy.protocol.command.response.LoginResponsePacket;
import personal.gzy.protocol.command.response.MessageResponsePacket;

import java.util.Date;

/**
 * @ClassName ServerHandler
 * @Description TODO netty 消息处理器
 * @Author GZY
 * @Date 2019/2/21 11:09
 * @Version
 **/
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf)msg;
//        System.out.println(new Date() +"：服务端读到数据 -> "+byteBuf.toString(Charset.forName("UTF-8")));
//        System.out.println(new Date() + "：服务端写出数据");
//        ByteBuf out = getByteBuf(ctx);
//        ctx.channel().writeAndFlush(out);
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if(packet instanceof LoginRequestPacket){
            LoginRequestPacket request = (LoginRequestPacket)packet;
            LoginResponsePacket response = new LoginResponsePacket();
            if("gzy".equals(request.getUsername())&&"123456".equals(request.getPassword())){
                response.setSuccess(true);
                System.out.println("客户端登陆成功...");
            }else{
                System.out.println("客户端登陆失败...");
                response.setSuccess(false);
                response.setReason("用户名或密码错误...");
            }
//            byteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(),response);
            ctx.channel().writeAndFlush(byteBuf);
        }else if(packet instanceof MessageRequestPacket){
            MessageRequestPacket msgReq = (MessageRequestPacket)packet;
            System.out.println(new Date()+"  收到来自客户端的消息："+msgReq.getMessage());
            MessageResponsePacket msgResp = new MessageResponsePacket();
            msgResp.setMessage("服务端回复【"+ msgReq.getMessage() +"】");
//            ByteBuf out = PacketCodeC.INSTANCE.encode(ctx.alloc(),msgResp);
//            ctx.channel().writeAndFlush(out);
        }
    }

}
