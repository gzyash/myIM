package personal.gzy.protocol.command.response;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

/**
 * @ClassName LoginResponsePacket
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/21 17:02
 * @Version
 **/
@Data
public class LoginResponsePacket extends Packet {
    private String userId;
    private String userName;
    private boolean success;
    private String reason;
    
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
