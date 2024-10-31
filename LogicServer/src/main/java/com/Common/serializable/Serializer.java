package com.Common.serializable;

public interface Serializer {

    public byte[] serialize(Object obj, Class<?> cls) throws Exception;

    public <T> T deserialize(byte[] data, Class<T> cls) throws Exception;
}
