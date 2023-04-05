package com.lee.blog.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/4 17:18
 * 统一返回结果对象
 */
@Data
@AllArgsConstructor
public class R {
    private boolean success;

    private int code;

    private String msg;

    private Object data;

    // 成功返回值
    public static R success(Object data){
        return new R(true,200,"success",data);
    }

    // 失败返回值
    public static R fail(int code, String msg){
        return new R(false,code,msg,null);
    }
}
