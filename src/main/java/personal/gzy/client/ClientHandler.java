package personal.gzy.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import personal.gzy.protocol.command.Packet;
import personal.gzy.protocol.command.PacketCodeC;
import personal.gzy.protocol.command.request.LoginRequestPacket;
import personal.gzy.protocol.command.response.LoginResponsePacket;
import personal.gzy.serialize.Serializer;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName ClientHandler
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/21 11:31
 * @Version
 **/
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf out = ctx.alloc().buffer().writeBytes("你好，我是客户端...".getBytes());
//        System.out.println(new Date() + "：客户端发送数据");
//        ctx.channel().writeAndFlush(out);
           //创建requestPacket
        LoginRequestPacket login = new LoginRequestPacket();
        login.setUserId(UUID.randomUUID().toString());
        login.setUsername("gzy");
        login.setPassword("123456");
        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(login);
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
          ByteBuf in = (ByteBuf)msg;
          Packet packet = PacketCodeC.INSTANCE.decode(in);
          if(packet instanceof LoginResponsePacket){
              LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
              if(loginResponsePacket.isSuccess()){
                  System.out.println("客户端登陆成功...");
              }else {
                  System.out.println("客户端登陆失败,因为:"+loginResponsePacket.getReason());
              }
          }
    }
}
