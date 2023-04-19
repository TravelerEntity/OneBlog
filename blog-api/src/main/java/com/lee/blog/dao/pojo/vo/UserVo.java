package com.lee.blog.dao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/17 20:11
 */
@Data
public class UserVo {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String avatar;

    private String nickname;
}
