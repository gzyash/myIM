package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.CreateGroupRequestPacket;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 创建群聊命令
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    public static final String USER_ID_SPLITER = ",";
    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        System.out.print("【拉人群聊】输入 userId 列表，userId 之间英文逗号隔开：");
        String userIds = scanner.nextLine();
        createGroupRequestPacket.setUserIds(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}
