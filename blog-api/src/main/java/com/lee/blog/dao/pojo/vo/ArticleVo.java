package com.lee.blog.dao.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 20:16
 */
@Data
public class ArticleVo {
    // 如果使用 fastJson，那么序列化和反序列化的相关包也要使用 fastJson 的，这样才能避免雪花 id 精度丢失的问题
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;

    // 作者
    private UserVo author;

    // 内容
    private ArticleBodyVo body;

    // 类别
    private CategoryVo category;

    // 标签
    private List<TagVo> tags;

    // 创建日期
    private String createDate;
}
