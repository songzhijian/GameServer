package com.gameengine.system.serializable;


public class SerializerUtils {

    private static ProtoBufSerializer serializer = new ProtoBufSerializer();

    public static <T> byte[] serialize(Object obj, Class<?> cls) throws Exception {
        return serializer.serialize(obj,cls);
    }

    public static <T> T deserialize(byte[] data, Class<T> cls) throws Exception{
        return serializer.deserialize(data,cls);
    }
}
