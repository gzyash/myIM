package personal.gzy.serialize.impl;

import com.alibaba.fastjson.JSON;
import personal.gzy.serialize.Serializer;
import personal.gzy.serialize.SerializerAlogrithm;

/**
 * @ClassName JSONSerializer
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/21 15:07
 * @Version
 **/
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
