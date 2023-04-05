package com.lee.blog.dao.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 20:16
 */
@Data
public class ArticleVo {
    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;

    // 作者 Id
    private String author;

    // 内容 Id
    // private Long bodyId;

    // 类别 Id
    // private Long categoryId;

    // 标签
    private List<TagVo> tags;

    // 创建日期
    private String createDate;
}
