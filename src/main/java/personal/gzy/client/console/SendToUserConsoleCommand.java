package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.MessageRequestPacket;

import java.util.Scanner;

public class SendToUserConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        String toUserId = scanner.next();
        String message = scanner.next();
        MessageRequestPacket mrp = new MessageRequestPacket();
        mrp.setToUserId(toUserId);
        mrp.setMessage(message);
        channel.writeAndFlush(mrp);
    }
}
