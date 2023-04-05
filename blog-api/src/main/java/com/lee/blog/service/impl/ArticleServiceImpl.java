package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.blog.dao.mapper.ArticleMapper;
import com.lee.blog.dao.pojo.Article;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.ArticleVo;
import com.lee.blog.dao.pojo.vo.PageParams;
import com.lee.blog.service.ArticleService;
import com.lee.blog.service.SysUserService;
import com.lee.blog.service.TagService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 19:50
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    SysUserService userService;

    @Override
    public R listArticle(PageParams pageParams) {
        // 分页查询
        // 构造 mybatisPlus 的分页对象
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        // 构造 lambdaQueryWrapper 对象, 查询对象
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // 增加查询条件
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);

        // 查询具体某一页
        Page<Article> resultPage = articleMapper.selectPage(page, queryWrapper);
        /* 为了避免视图模型和数据库过度耦合, 所以需要 VO 对象来解耦`";'
         * VO 是与前端直接交互的对象, 因为前端通常不会需要数据库的全部字段
         * 这样做的目的在于, 如果前端显示的对象字段有变化(可能行很大), 那么我们后端可以任意调整
         * 而不用去改动原有的 POJO 打乱和数据库的映射
         * POJO 是与数据库进行一对一映射的对象
         */

        List<Article> records = resultPage.getRecords();
        // 把 pojo 对象转换成 vo 对象
        List<ArticleVo> voRecords = copyList(records);

        return R.success(voRecords);
    }


    /**
     * 转换 articleList 为 articleVoList
     * @param records
     * @return articleVoList
     */
    private List<ArticleVo> copyList(List<Article> records) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        records.forEach( article -> articleVoList.add( copyOne(article, true, true) ));
        return articleVoList;
    }

    /**
     * 转换 article 为 articleVo
     * @param article
     * @return articleVo
     */
    private ArticleVo copyOne(Article article, boolean isTag, boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        // 使用工具类自动复制值
        BeanUtils.copyProperties(article, articleVo);
        // 手动设置日期信息
        articleVo.setCreateDate(new DateTime(article.getCreateDate() ).toString("yyyy-MM-dd HH:mm"));

        // 并不是所有接口都需要 标签和作者信息, 所以我们可以编写分支
        if(isTag){
            // 手动设置标签
            articleVo.setTags(tagService.findTagsByArticleId(article.getId()));
        }
        if(isAuthor){
            // 手动设置作者
            articleVo.setAuthor(userService.findUserById(article.getAuthorId()).getNickname() );
        }
        System.out.println("article VO#### = "+ articleVo);

        return articleVo;
    }
}
