package com.lee.blog.dao.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/4 20:24
 */

@Data
@TableName("ms_tag")
public class TagVo {
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String tagName;

    private String avatar;
}
