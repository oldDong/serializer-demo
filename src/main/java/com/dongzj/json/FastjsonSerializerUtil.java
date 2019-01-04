package com.dongzj.json;

import com.alibaba.fastjson.JSON;

/**
 * fastjson序列化
 *
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 14:23
 */
public class FastjsonSerializerUtil {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        long start = System.currentTimeMillis();
        byte[] bytes = JSON.toJSONBytes(obj);
        long end = System.currentTimeMillis();
        System.out.println("fastjson序列化length: " + bytes.length);
        System.out.println("fastjson序列化耗时：" + (end - start));
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

        long start = System.currentTimeMillis();
        T t = JSON.parseObject(data, clazz);
        long end = System.currentTimeMillis();
        System.out.println("fastjson反序列化结果：" + t);
        System.out.println("fastjson反序列化耗时：" + (end - start));
        return t;
    }
}
