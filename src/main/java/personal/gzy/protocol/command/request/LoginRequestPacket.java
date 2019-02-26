package personal.gzy.protocol.command.request;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

/**
 * @ClassName LoginRequestPacket
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/21 15:00
 * @Version
 **/
@Data
public class LoginRequestPacket extends Packet {
     private String username;
     private String password;
    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
