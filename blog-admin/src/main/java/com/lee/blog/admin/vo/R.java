package com.lee.blog.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/30 21:01
 */

@Data
@AllArgsConstructor
public class R {
    private boolean success;

    private int code;

    private String msg;

    private Object data;

    public static R success(Object data){
       return new R(true, 200, "success", data);
    }
    public static R success(){
        return new R(true, 200, "success", null);
    }

    public static R fail(int code, String msg){
        return new R(false,code, msg, null);
    }
}
