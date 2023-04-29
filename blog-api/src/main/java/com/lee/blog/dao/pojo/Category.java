package com.lee.blog.dao.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.lang.annotation.Target;

/**
 * Created by Lee Yian on 2023/4/16 15:00
 */
@Data
@TableName("ms_category")
public class Category {
    private Long id;

    private String avatar;

    private String categoryName;

    private String description;

}
