package com.lee.blog.dao.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 20:16
 */
@Data
public class ArticleVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;

    // 作者
    private String author;

    // 内容
    private ArticleBodyVo body;

    // 类别
    private CategoryVo category;

    // 标签
    private List<TagVo> tags;

    // 创建日期
    private String createDate;
}
