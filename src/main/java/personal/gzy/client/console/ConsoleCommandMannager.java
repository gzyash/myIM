package personal.gzy.client.console;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.HttpServerKeepAliveHandler;
import personal.gzy.util.SessionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleCommandMannager implements ConsoleCommand {
    private static Map<String,ConsoleCommand> consoleCommandMap = new HashMap<>();
    static{
        consoleCommandMap.put("createGroup",new CreateGroupConsoleCommand());
        consoleCommandMap.put("logOut",new LoginOutConsoleCommand());
        consoleCommandMap.put("sendToUser",new SendToUserConsoleCommand());
    }

    @Override
    public void exec(Scanner scanner, Channel channel) {
        String command = scanner.nextLine();
        if(!SessionUtil.hasLogin(channel)){
            return;
        }
        ConsoleCommand consoleCommand = consoleCommandMap.get(command);
        if (consoleCommand != null) {
            consoleCommand.exec(scanner,channel);
        }else{
            System.err.println("无法识别[ "+command+" ]指令，请重新输入!");
        }
    }
}
