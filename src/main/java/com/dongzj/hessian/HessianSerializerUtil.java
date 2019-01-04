package com.dongzj.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * hessian序列化
 * <p>
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 13:52
 */
public class HessianSerializerUtil {

    /**
     * 序列化
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos;
        HessianOutput hessianOutput;
        try {
            bos = new ByteArrayOutputStream();
            hessianOutput = new HessianOutput(bos);
            //obj必须实现Serializable接口
            long start = System.currentTimeMillis();
            hessianOutput.writeObject(obj);
            long end = System.currentTimeMillis();
            bytes = bos.toByteArray();
            System.out.println("hessian序列化后length: " + bytes.length);
            System.out.println("hessian序列化耗时：" + (end - start));
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
    public static <T> T deserialize(byte[] data) {
        if (data == null) {
            return null;
        }
        T t = null;
        ByteArrayInputStream bis;
        HessianInput hessianInput;
        try {
            bis = new ByteArrayInputStream(data);
            hessianInput = new HessianInput(bis);
            long start = System.currentTimeMillis();
            t = (T) hessianInput.readObject();
            long end = System.currentTimeMillis();
            System.out.println("hessian反序列化结果：" + t);
            System.out.println("hessian反序列化耗时：" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
