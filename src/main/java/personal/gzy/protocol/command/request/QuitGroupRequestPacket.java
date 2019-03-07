package personal.gzy.protocol.command.request;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;
@Data
public class QuitGroupRequestPacket extends Packet {
    private String groupId;
    private String userId;
    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_REQUEST;
    }
}
