package com.lee.blog.dao.pojo.vo.params;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/5 20:34
 */
@Data
public class LoginParam {
    private String account;
    private String password;

    private String nickname;
}
