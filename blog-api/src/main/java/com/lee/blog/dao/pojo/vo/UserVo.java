package com.lee.blog.dao.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/17 20:11
 */
@Data
public class UserVo {

    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String avatar;

    private String nickname;
}
