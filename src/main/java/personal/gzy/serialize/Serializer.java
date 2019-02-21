package personal.gzy.serialize;

import personal.gzy.serialize.impl.JSONSerializer;

public interface Serializer {
    Serializer DEFUALT = new JSONSerializer();
    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * java序列化成二进制
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制转化为java对象
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz,byte[] bytes);
}
