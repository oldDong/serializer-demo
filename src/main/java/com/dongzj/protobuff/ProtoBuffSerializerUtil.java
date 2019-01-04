package com.dongzj.protobuff;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

import java.io.IOException;

/**
 * ProtoBuff序列化
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 14:37
 */
public class ProtoBuffSerializerUtil {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        Codec classCodec = ProtobufProxy.create(obj.getClass(), false);
        byte[] bytes = null;
        try {
            long start = System.currentTimeMillis();
            bytes = classCodec.encode(obj);
            long end = System.currentTimeMillis();
            System.out.println("protobuff序列化结果length: " + bytes.length);
            System.out.println("protobuff序列化耗时：" + (end - start));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 反序列化
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {
        if (data == null) {
            return null;
        }
        T t = null;
        Codec classCodec = ProtobufProxy.create(clazz, false);
        try {
            long start = System.currentTimeMillis();
            t = (T) classCodec.decode(data);
            long end = System.currentTimeMillis();
            System.out.println("protobuff反序列化结果：" + t);
            System.out.println("protobuff反序列化耗时：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
