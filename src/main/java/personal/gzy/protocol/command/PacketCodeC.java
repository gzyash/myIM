package personal.gzy.protocol.command;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import personal.gzy.protocol.command.request.LoginRequestPacket;
import personal.gzy.serialize.Serializer;
import personal.gzy.serialize.impl.JSONSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PacketCodeC
 * @Description TODO编码解码
 * @Author GZY
 * @Date 2019/2/21 15:23
 * @Version 协议格式：
 * ------------------ --------- ---------- ------- ------------------ ------------------------------------
 * 魔术(0x12345678)    version  序列化算法   指令       数据长度                   数据
 * ------------------ --------- ---------- ------- ------------------ ------------------------------------
 * 4BYTE          1BYTE     1BYTE      1BYTE        4BYTE                       N字节
 **/
public class PacketCodeC {
    public static final PacketCodeC INSTANCE = new PacketCodeC();
    public static final int MAGIC_NUMBER = 0X12345678;
    public static final Map<Byte, Class<? extends Packet>> packetTypeMap;
    public static final Map<Byte, Serializer> serializerMap;

    static {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }

    public ByteBuf encode(Packet packet) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.ioBuffer();
        byte[] bytes = Serializer.DEFUALT.serialize(packet);
        buffer.writeInt(MAGIC_NUMBER);
        buffer.writeByte(packet.getVersion());
        buffer.writeByte(Serializer.DEFUALT.getSerializerAlgorithm());
        buffer.writeByte(packet.getCommand());
        buffer.writeInt(bytes.length);
        buffer.writeBytes(bytes);
        return buffer;
    }

    public Packet decode(ByteBuf byteBuf) {
        byteBuf.skipBytes(4);
        byteBuf.skipBytes(1);
        //序列化算法标示
        byte serializeAlgorithm = byteBuf.readByte();
        //命令
        byte command = byteBuf.readByte();
        int len = byteBuf.readInt();
        byte[] datas = new byte[len];
        byteBuf.readBytes(datas);

        Class<? extends Packet> packet = getRequestType(command);

        Serializer serializer = getSerializer(serializeAlgorithm);
        if (packet != null && serializer != null) {
            return serializer.deserialize(packet, datas);
        }
        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {
        return packetTypeMap.get(command);
    }
}
