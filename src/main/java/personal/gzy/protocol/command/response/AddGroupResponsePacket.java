package personal.gzy.protocol.command.response;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

import java.util.List;

@Data
public class AddGroupResponsePacket extends Packet {
    private String groupId;
    private boolean success;
    private List<String> userNameList;
    private String reason;
    @Override
    public Byte getCommand() {
        return Command.ADD_GROUP_RESPONSE;
    }
}
