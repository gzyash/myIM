package personal.gzy.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import personal.gzy.protocol.command.request.AddGroupRequestPacket;
import personal.gzy.protocol.command.request.CreateGroupRequestPacket;
import personal.gzy.protocol.command.response.AddGroupResponsePacket;
import personal.gzy.protocol.command.response.CreateGroupResponsePacket;
import personal.gzy.util.IdUtil;
import personal.gzy.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

public class AddGroupRequestHandler extends SimpleChannelInboundHandler<AddGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddGroupRequestPacket addGroupRequestPacket) throws Exception {
        String groupId = addGroupRequestPacket.getGroupId();
        String userId = addGroupRequestPacket.getUserId();
        ChannelGroup group = SessionUtil.getGroupByGroupId(groupId);
        group.add(SessionUtil.getChannel(userId));
        AddGroupResponsePacket addGroupResponsePacket = new AddGroupResponsePacket();
        addGroupResponsePacket.setGroupId(groupId);
        addGroupResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(addGroupResponsePacket);
    }
}
