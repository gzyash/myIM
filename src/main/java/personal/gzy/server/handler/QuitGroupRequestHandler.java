package personal.gzy.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import personal.gzy.protocol.command.request.AddGroupRequestPacket;
import personal.gzy.protocol.command.request.QuitGroupRequestPacket;
import personal.gzy.protocol.command.response.AddGroupResponsePacket;
import personal.gzy.protocol.command.response.QuitGroupResponsePacket;
import personal.gzy.util.SessionUtil;

public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket quitGroupRequestPacket) throws Exception {
        String groupId = quitGroupRequestPacket.getGroupId();
        String userId = quitGroupRequestPacket.getUserId();
        ChannelGroup group = SessionUtil.getGroupByGroupId(groupId);
        group.remove(SessionUtil.getChannel(userId));
        QuitGroupResponsePacket quitGroupResponsePacket = new QuitGroupResponsePacket();
        quitGroupResponsePacket.setGroupId(groupId);
        quitGroupResponsePacket.setSuccess(true);
        ctx.channel().writeAndFlush(quitGroupResponsePacket);
    }

}
