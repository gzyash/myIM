package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.AddGroupRequestPacket;
import personal.gzy.protocol.command.request.LoginOutRequestPacket;

import java.util.Scanner;

public class AddGroupConsoleCommand implements ConsoleCommand {
    public static final String USERID_GROUPID_SPLITER = ",";
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入加入群ID和用户ID，用逗号分隔.");
        String groupIdAnduserId = scanner.nextLine();
        String[] tmp = groupIdAnduserId.split(USERID_GROUPID_SPLITER);
        AddGroupRequestPacket addGroupRequestPacket = new AddGroupRequestPacket();
        addGroupRequestPacket.setGroupId(tmp[0]);
        addGroupRequestPacket.setUserId(tmp[1]);
        channel.writeAndFlush(addGroupRequestPacket);
    }
}
