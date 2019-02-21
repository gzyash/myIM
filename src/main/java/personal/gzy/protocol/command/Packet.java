package personal.gzy.protocol.command;

import lombok.Data;

/**
 * @ClassName Packet
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/21 14:56
 * @Version
 **/
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     * @return
     */
    public abstract Byte getCommand();
}
