package personal.gzy.protocol.command.request;

import lombok.Data;
import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

import java.util.List;

@Data
public class CreateGroupRequestPacket extends Packet {
    private List<String> userIds;

    @Override
    public Byte getCommand() {
        return Command.CREATEGROUP_REQUEST;
    }
}
