package com.dongzj.entity;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.Data;

import java.io.Serializable;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/14
 * Time: 14:43
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4928786637283599478L;

    @Protobuf(fieldType = FieldType.INT32, required = false, order = 1)
    private Integer userId;

    @Protobuf(fieldType = FieldType.STRING, required = false, order = 2)
    private String userName;

    @Protobuf(fieldType = FieldType.STRING, required = false, order = 3)
    private String password;

    @Protobuf(fieldType = FieldType.STRING, required = false, order = 4)
    private String userInfo;
}
