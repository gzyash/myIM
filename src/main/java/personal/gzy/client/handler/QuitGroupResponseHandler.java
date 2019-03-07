package personal.gzy.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.response.CreateGroupResponsePacket;
import personal.gzy.protocol.command.response.QuitGroupResponsePacket;

public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket quitGroupResponsePacket) throws Exception {
        System.out.print("退群成功，id 为[" + quitGroupResponsePacket.getGroupId() + "], ");
    }
}
