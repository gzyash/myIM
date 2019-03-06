package personal.gzy.protocol.command.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;
@Data
public class LoginOutResponsePacket extends Packet {
    /*
     *是否退出成功
     */
    private boolean success;
    /*
     *原因描述
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGINOUT_RESPONSE;
    }
}
