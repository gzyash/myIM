package personal.gzy.protocol.command.response;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

/**
 * @ClassName MessageResponsePacket
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/22 11:44
 * @Version
 **/
@Data
public class MessageResponsePacket extends Packet {
    private String message;
    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
