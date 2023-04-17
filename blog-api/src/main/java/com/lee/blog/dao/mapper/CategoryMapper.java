package com.lee.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.dao.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Lee Yian on 2023/4/17 14:57
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
