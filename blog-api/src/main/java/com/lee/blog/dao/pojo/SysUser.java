package com.lee.blog.dao.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class SysUser {

    // @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;

    @JSONField(serialize = false)
    private Integer deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    // 指定不参数序列化
    @JSONField(serialize = false)
    private String password;

    @JSONField(serialize = false)
    private String salt;

    @JSONField(serialize = false)
    private String status;
}

