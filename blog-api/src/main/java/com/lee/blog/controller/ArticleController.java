package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.PageParams;
import com.lee.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee Yian on 2023/4/4 17:05
 * 首页功能接口
 */
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 首页文章列表,
     * @param pageParams pageParams vo, it has a page int And a pageSize
     * @return R
     */
    @PostMapping()
    public R listArticles(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }

    /**
     * 首页 热门文章
     * @return R
     */
    @PostMapping("hot")
    public R hotArticle(){
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    /**
     * 首页 最新文章
     * @return R
     */
    @PostMapping("new")
    public R newArticles(){
        int limit = 5;
        return articleService.newArticle(limit);
    }

    /**
     * 首页 文章归档
     * @return R
     */
    @PostMapping("listArchives")
    public R listArchives(){
        return articleService.listArchives();
    }

    /**
     * 查看文章详情
     * @param id 文章 id
     * @return R
     */
    @PostMapping("view/{id}")
    public R view(@PathVariable Long id){
        return articleService.findArticleById(id);
    }
}
