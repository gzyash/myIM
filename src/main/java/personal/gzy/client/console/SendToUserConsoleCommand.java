package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.MessageRequestPacket;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入userId");
        String toUserId = scanner.nextLine();
        System.out.println("请输入消息内容");
        String message = scanner.nextLine();
        MessageRequestPacket mrp = new MessageRequestPacket();
        mrp.setToUserId(toUserId);
        mrp.setMessage(message);
        channel.writeAndFlush(mrp);
    }
}
