package com.lee.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.dao.dto.Archive;
import com.lee.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 16:49
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archive> listArchives();
}
