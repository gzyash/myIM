package personal.gzy.protocol.command.request;

import personal.gzy.protocol.command.Command;
import personal.gzy.protocol.command.Packet;

public class LoginOutRequestPacket extends Packet
{
    @Override
    public Byte getCommand() {
        return Command.LOGINOUT_REQEUST;
    }
}
