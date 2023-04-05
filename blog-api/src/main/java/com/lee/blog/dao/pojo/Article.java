package com.lee.blog.dao.pojo;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/4 16:45
 */
@Data
public class Article {
    public static final int Article_Top = 1;
    public static final int Article_Common = 0;

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;

    // 作者 Id
    private Long authorId;

    // 内容 Id
    private Long bodyId;

    // 类别 Id
    private Long categoryId;

    // 创建日期
    private Long createDate;
}
