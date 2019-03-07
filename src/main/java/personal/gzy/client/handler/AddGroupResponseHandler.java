package personal.gzy.client.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import personal.gzy.protocol.command.response.AddGroupResponsePacket;
import personal.gzy.protocol.command.response.CreateGroupResponsePacket;
import personal.gzy.protocol.command.response.QuitGroupResponsePacket;

public class AddGroupResponseHandler extends SimpleChannelInboundHandler<AddGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddGroupResponsePacket addGroupResponsePacket) throws Exception {
        if(addGroupResponsePacket.isSuccess()){
            System.out.print("加群成功，id 为[" + addGroupResponsePacket.getGroupId() + "], ");
        }
    }
}
