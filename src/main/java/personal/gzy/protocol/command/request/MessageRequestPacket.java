package personal.gzy.protocol.command.request;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

/**
 * @ClassName MessageRequestPacket
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/22 11:44
 * @Version
 **/
@Data
public class MessageRequestPacket extends Packet {
    private String message;
    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
