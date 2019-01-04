package com.dongzj.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 连接参数
 *
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/11/13
 * Time: 14:54
 */
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = -643843819188232953L;

    private String name;

    private String host;

    private Integer port;
}
