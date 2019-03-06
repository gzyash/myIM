package personal.gzy.protocol.command.response;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

import java.util.List;
@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;
    private String reason;
    private List<String> userNameList;
    private String groupId;
    @Override
    public Byte getCommand() {
        return Command.CREATEGROUP_RESPONSE;
    }
}
