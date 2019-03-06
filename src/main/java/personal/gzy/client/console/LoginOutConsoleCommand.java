package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.LoginOutRequestPacket;

import java.util.Scanner;

public class LoginOutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginOutRequestPacket loginOutRequestPacket = new LoginOutRequestPacket();
        channel.writeAndFlush(loginOutRequestPacket);
    }
}
