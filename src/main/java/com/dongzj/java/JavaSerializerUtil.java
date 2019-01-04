package com.dongzj.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java序列化
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 13:40
 */
public class JavaSerializerUtil {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        byte[] bytes = null;
        ByteArrayOutputStream out;
        ObjectOutputStream objOut;
        try {
            out = new ByteArrayOutputStream();
            objOut = new ObjectOutputStream(out);
            long start = System.currentTimeMillis();
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            long end = System.currentTimeMillis();
            bytes = out.toByteArray();
            System.out.println("java序列化后length: " + bytes.length);
            System.out.println("java序列化耗时：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        T t = null;
        ByteArrayInputStream in;
        ObjectInputStream objIn;
        try {
            in = new ByteArrayInputStream(bytes);
            objIn = new ObjectInputStream(in);
            long start = System.currentTimeMillis();
            t = (T) objIn.readObject();
            long end = System.currentTimeMillis();
            objIn.close();
            System.out.println("java反序列化结果：" + t);
            System.out.println("java反序列化耗时：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
