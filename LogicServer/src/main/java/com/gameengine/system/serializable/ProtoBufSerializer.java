package com.gameengine.system.serializable;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ProtoBufSerializer implements Serializer {

    private Map<String, Codec> codecCache = new ConcurrentHashMap<>();

    @Override
    public  byte[] serialize(Object obj, Class<?> cls) throws Exception {
        Codec codec = this.getCodec(cls);
        return codec.encode(obj);
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> cls) throws Exception {
        Codec<T> codec = this.getCodec(cls);
        return codec.decode(data);
    }

    public <T> Codec<T> getCodec(Class<T> cls) {
        String uniClsName = cls.getName();
        Codec<T> codec = codecCache.get(uniClsName);
        if (Objects.nonNull(codec)) {
            return codec;
        }
        String fullClassName = ProtobufProxy.getFullClassName(cls);
        try {
            Class<?> codecCls = Class.forName(fullClassName, true, cls.getClassLoader());
            codec = (Codec<T>) codecCls.newInstance();
            codecCache.put(uniClsName, codec);
            return codec;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
