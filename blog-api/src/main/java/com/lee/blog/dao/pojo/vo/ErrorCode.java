package com.lee.blog.dao.pojo.vo;

/**
 * Created by Lee Yian on 2023/4/8 21:57
 * 错误代码的枚举类
 */
public enum ErrorCode {

    // 错误码
    PARAMS_ERROR(10001,"参数有误"),
    ACCOUNT_PWD_NOT_EXISTS(10002,"账号或密码错误"),
    ACCOUNT_ALREADY_EXISTS(10004,"账号已存在"),
    TOKEN_NOT_EXISTS(10002,"Token 无效"),
    NO_PERMISSION(70001,"无访问权限"),
    SESSION_TIMEOUT(90001,"会话过期"),
    NO_LOGIN(90002,"未登录");
    private int code;
    private String msg;

    ErrorCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
