package com.lee.blog.service.impl;

import com.lee.blog.dao.mapper.CategoryMapper;
import com.lee.blog.dao.pojo.Category;
import com.lee.blog.dao.pojo.vo.CategoryVo;
import com.lee.blog.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lee Yian on 2023/4/17 14:56
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long id) {
        Category category = categoryMapper.selectById(id);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
