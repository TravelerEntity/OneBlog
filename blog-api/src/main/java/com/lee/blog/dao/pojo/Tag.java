package com.lee.blog.dao.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

@Data
public class Tag {

    private Long id;

    // 标签图标
    private String avatar;

    private String tagName;

}

