package com.lee.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lee.blog.dao.mapper.ArticleMapper;
import com.lee.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by Lee Yian on 2023/4/17 16:28
 * 线程服务
 */

@Component
public class ThreadService {

    @Async("taskExecutor")
    public void updateViewCount(ArticleMapper articleMapper, Article article) {
        /*  这里我们拿到了 articleMapper 和 article
            1. 为了减少 payload，我们构造一个新的 article对象
            2. 构造执行 update 操作的查询器
         */

        Integer viewCount = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCount + 1);

        LambdaQueryWrapper<Article> updateWrapper = new LambdaQueryWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        updateWrapper.eq(Article::getViewCounts,article.getViewCounts());

        // sql = update article set view_count = #{articleUpdate.viewCount} where id = #{article.id} and view_count = #{view_count}
        articleMapper.update(articleUpdate,updateWrapper);
    }
}
