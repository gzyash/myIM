package personal.gzy.client.console;

import io.netty.channel.Channel;
import personal.gzy.protocol.command.request.LoginRequestPacket;

import java.util.Scanner;

public class LoginConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("请输入用户名:");
        String userName = scanner.nextLine();
        LoginRequestPacket lrp = new LoginRequestPacket();
        lrp.setUsername(userName);
        lrp.setPassword("pwd");
        channel.writeAndFlush(lrp);
    }
}
