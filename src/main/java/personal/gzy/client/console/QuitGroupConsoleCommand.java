package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.AddGroupRequestPacket;
import personal.gzy.protocol.command.request.QuitGroupRequestPacket;

import java.util.Scanner;

public class QuitGroupConsoleCommand implements ConsoleCommand {
    public static final String USERID_GROUPID_SPLITER = ",";
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入退出群ID和用户ID，用逗号分隔.");
        String groupIdAnduserId = scanner.nextLine();
        String[] tmp = groupIdAnduserId.split(USERID_GROUPID_SPLITER);
        QuitGroupRequestPacket quitGroupRequestPacket = new QuitGroupRequestPacket();
        quitGroupRequestPacket.setGroupId(tmp[0]);
        quitGroupRequestPacket.setUserId(tmp[1]);
        channel.writeAndFlush(quitGroupRequestPacket);
    }
}
