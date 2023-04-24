package com.lee.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.blog.dao.pojo.Article;
import com.lee.blog.dao.pojo.ArticleBody;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Lee Yian on 2023/4/16 15:10
 */
@Mapper
public interface ArticleBodyMapper extends BaseMapper<ArticleBody> {
}
