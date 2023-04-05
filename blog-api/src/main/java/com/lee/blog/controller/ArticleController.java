package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.PageParams;
import com.lee.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee Yian on 2023/4/4 17:05
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
    public R listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);
    }
}
