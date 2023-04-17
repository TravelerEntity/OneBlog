package com.lee.blog.dao.pojo;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/4 16:45
 * DTO 类的属性要使用包裹类的原因是因为：
 * 1. 基本类型会有默认值，在我们使用框架与数据库进行交互时，会发生意想不到的问题
 * 比如一条这样的 slq：UPDATE ms_article SET comment_counts=?, view_counts=?, weight=? WHERE (id = ? AND view_counts = ?)
 * 实际上我们设置了 view——counts 和 id 的值，但是却多出来了 comment_counts and weight
 * 原因是，因为它们使用了基本类型，基本类型初始化后会有默认值，int 默认值为 0
 * 而我们的 ORM 框架在执行更新时会自动对不为 null 值的属性建立更新字段
 * 最终表现出来的就是多出了几个更新的属性，同时也会导致我们数据库的数据被意外地归零
 */
@Data
public class Article {
    public static final int Article_Top = 1;
    public static final int Article_Common = 0;

    private Long id;

    private String title;

    // 简介
    private String summary;

    // 评论量
    private Integer commentCounts;

    // 浏览量
    private Integer viewCounts;

    // 文章权重，1 置顶
    private Integer weight;

    // 作者 Id
    private Long authorId;

    // 内容 Id
    private Long bodyId;

    // 类别 Id
    private Long categoryId;

    // 创建日期
    private Long createDate;
}
