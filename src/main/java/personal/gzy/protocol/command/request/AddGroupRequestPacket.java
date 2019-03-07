package personal.gzy.protocol.command.request;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;
@Data
public class AddGroupRequestPacket extends Packet {
    private String groupId;
    private String userId;
    @Override
    public Byte getCommand() {
        return Command.ADD_GROUP_REQUEST;
    }
}
