package com.dongzj;

import com.dongzj.entity.User;
import com.dongzj.hessian.HessianSerializerUtil;
import com.dongzj.java.JavaSerializerUtil;
import com.dongzj.json.FastjsonSerializerUtil;
import com.dongzj.json.JacksonSerializerUtil;
import com.dongzj.protobuff.ProtoBuffSerializerUtil;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 14:06
 */
public class main {

    public static void main(String[] args) {
//        Address address = new Address();
//        address.setName("序列化方式比较");
//        address.setHost("127.0.0.1");
//        address.setPort(16999);

        User user = new User();
        user.setUserId(100);
        user.setUserName("张三丰");
        user.setPassword("fengsanzhang");
        user.setUserInfo("序列化方式比较");

        //java序列化
        byte[] bytes = JavaSerializerUtil.serialize(user);
        JavaSerializerUtil.deserialize(bytes);
        System.out.println();

        //hessian序列化
        bytes = HessianSerializerUtil.serialize(user);
        HessianSerializerUtil.deserialize(bytes);
        System.out.println();

        //protoBuff序列化
        bytes = ProtoBuffSerializerUtil.serialize(user);
        ProtoBuffSerializerUtil.deserialize(bytes, User.class);
        System.out.println();

        //jackson序列化
        bytes = JacksonSerializerUtil.serialize(user);
        JacksonSerializerUtil.deserialize(bytes, User.class);
        System.out.println();

        //fastjson序列化
        bytes = FastjsonSerializerUtil.serialize(user);
        FastjsonSerializerUtil.deserialize(bytes, User.class);
        System.out.println();

    }
}
