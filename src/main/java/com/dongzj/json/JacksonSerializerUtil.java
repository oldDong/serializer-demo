package com.dongzj.json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json-jackson序列化
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 14:11
 */
public class JacksonSerializerUtil {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        byte[] bytes = null;
        ObjectMapper objectMapper;
        try {
            objectMapper = new ObjectMapper();
            long start = System.currentTimeMillis();
            bytes = objectMapper.writeValueAsBytes(obj);
            long end = System.currentTimeMillis();
            System.out.println("jackson序列化后length: " + bytes.length);
            System.out.println("jackson序列化耗时：" + (end - start));
        } catch (Exception e) {
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
        ObjectMapper objectMapper;
        try {
            objectMapper = new ObjectMapper();
            long start = System.currentTimeMillis();
            t = (T) objectMapper.readValue(data, clazz);
            long end = System.currentTimeMillis();
            System.out.println("jackson反序列化结果：" + t);
            System.out.println("jackson反序列化耗时：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
