package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.blog.dao.dto.Archive;
import com.lee.blog.dao.mapper.ArticleBodyMapper;
import com.lee.blog.dao.mapper.ArticleMapper;
import com.lee.blog.dao.pojo.Article;
import com.lee.blog.dao.pojo.ArticleBody;
import com.lee.blog.dao.pojo.Category;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.ArticleBodyVo;
import com.lee.blog.dao.pojo.vo.ArticleVo;
import com.lee.blog.dao.pojo.vo.CategoryVo;
import com.lee.blog.dao.pojo.vo.PageParams;
import com.lee.blog.service.*;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
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
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    ArticleBodyMapper articleBodyMapper;

    @Autowired
    private TagService tagService;

    @Autowired
    SysUserService userService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ThreadService threadService;

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
        List<ArticleVo> voRecords = copyList(records, true,true);

        return R.success(voRecords);
    }

    @Override
    public R hotArticle(int limit) {
        // 1. 构造查询对象
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts)
                .select(Article::getId,Article::getTitle)
                .last("limit "+limit);
        // select id, title from article order by view_counts desc limit 5
        // 2. 查询对应记录
        val articleList = articleMapper.selectList(queryWrapper);
        // 3. 转换为 VO 对象
        val articleVoList = copyList(articleList, false, false);

        return R.success(articleVoList);
    }

    @Override
    public R newArticle(int limit) {
        // 1. 构造查询器
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate)
                .select(Article::getId,Article::getTitle)
                .last("limit "+limit);
        // select id,title from article order by create_date desc limit 5

        // 2.执行查询
        val articleList = articleMapper.selectList(queryWrapper);
        List<ArticleVo> articleVoList = copyList(articleList,false,false);
        return R.success(articleVoList);
    }

    @Override
    public R listArchives() {
        // 特殊查询用 mapper 完成
        List<Archive> archiveList = articleMapper.listArchives();
        return R.success(archiveList);
    }

    @Override
    public R findArticleById(Long id) {
        /*
            1. 根据 article id 查询对应的 article 表中的 body id，和 tag 表中 id
            2. 根据 body id 查询 body 表中 body，tag id 查询对应的 tag
            3. 组合一个 articleVO 返回
         */
        // 1. 查询 article by article id
        Article article = articleMapper.selectById(id);
        // 2. 查询 body 和 category 操作交给 copyOne (一次只会查看一个文章详情) 中执行，因为在 article 中已经给出了它们各自的 id
        ArticleVo articleVo = copyOne(article,true,true,true,true);

        // 3. 返回完文章后，对文章查看次数执行 +1 操作
        /*
            Q: Why do we use thread pool here instead of updating directly
            A: Because the updating operation, though a small action, may block the whole method's process.
                If the updating takes a long time, the return will also take a long time to wait.
         */
        threadService.updateViewCount(articleMapper, article);
        return R.success(articleVo);
    }


    /**
     * 转换 articleList 为 articleVoList
     * @param records records
     * @return articleVoList
     */
    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        records.forEach( article -> articleVoList.add( copyOne(article, isTag, isAuthor,false,false) ));
        return articleVoList;
    }
    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        records.forEach( article -> articleVoList.add( copyOne(article, isTag, isAuthor, isBody, isCategory) ));
        return articleVoList;
    }

    /**
     * 转换 article 为 articleVo
     * @param article article
     * @return articleVo
     */
    private ArticleVo copyOne(Article article, boolean isTag, boolean isAuthor, boolean isBody, boolean isCategory){
        ArticleVo articleVo = new ArticleVo();
        // 使用工具类自动复制值
        BeanUtils.copyProperties(article, articleVo);
        // 手动设置日期信息，如果没有值它默认则是今天
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
        if(isBody){
            // 查询并设置 body
            // ArticleBody articleBody = articleBodyMapper.selectById(article.getBodyId());
            ArticleBodyVo articleBodyVo = findArticleBodyById(article.getBodyId());
            articleVo.setBody(articleBodyVo);
        }
        if(isCategory){
            // 查询并设置 category
            CategoryVo categoryVo = categoryService.findCategoryById(article.getCategoryId());
            articleVo.setCategory(categoryVo);
        }
        return articleVo;
    }

    private ArticleBodyVo findArticleBodyById(Long bodyId) {
        ArticleBody body = articleBodyMapper.selectById(bodyId);
        ArticleBodyVo bodyVo = new ArticleBodyVo();
        bodyVo.setContent(body.getContent());
        return bodyVo;
    }
}
