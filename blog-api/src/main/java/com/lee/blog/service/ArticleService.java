package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.PageParams;

/**
 * Created by Lee Yian on 2023/4/4 17:36
 */

public interface ArticleService {

    /**
     * 分页返回首页文章
     * @param pageParams 分页对象
     * @return R
     */
    R listArticle(PageParams pageParams);

    /**
     * 返回 首页 热门文章
     * @param limit 前 limit 条
     * @return R
     */
    R hotArticle(int limit);

    /**
     * 返回 首页 最新文章
     * @param limit 前 limit 条
     * @return R
     */
    R newArticle(int limit);

    /**
     * 返回文章归档信息
     * @return R
     */
    R listArchives();

    /**
     * 根据 id 返回文章的详情
     * @param id 文章 id long
     * @return R
     */
    R findArticleById(Long id);
}
