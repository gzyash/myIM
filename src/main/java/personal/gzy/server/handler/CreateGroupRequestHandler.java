package personal.gzy.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import personal.gzy.protocol.command.request.CreateGroupRequestPacket;
import personal.gzy.protocol.command.response.CreateGroupResponsePacket;
import personal.gzy.util.IdUtil;
import personal.gzy.util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
        List<String> userIds = createGroupRequestPacket.getUserIds();
        List<String> userNameList = new ArrayList<>();
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        for (String userId : userIds) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null) {
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setReason("");
        createGroupResponsePacket.setUserNameList(userNameList);
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(IdUtil.createId());
        channelGroup.writeAndFlush(createGroupResponsePacket);//群发送
        SessionUtil.addGroup(createGroupResponsePacket.getGroupId(),channelGroup);
        System.out.println("用户[ " +SessionUtil.getSession(ctx.channel()).getUserName()+ " ]创建群成功，群ID为："+createGroupResponsePacket.getGroupId());
        System.out.println("群里面用户有："+userNameList);
    }
}
