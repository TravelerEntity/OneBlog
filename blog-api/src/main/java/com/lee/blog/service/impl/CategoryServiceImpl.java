package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee.blog.dao.mapper.CategoryMapper;
import com.lee.blog.dao.pojo.Category;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.CategoryVo;
import com.lee.blog.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Yian on 2023/4/17 14:56
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryVoById(Long id) {
        Category category = categoryMapper.selectById(id);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }

    @Override
    public R findAll() {
        List<Category> categoryList = categoryMapper.selectList(new QueryWrapper<>());
        List<CategoryVo> categoryVoList = copyList(categoryList);
        return R.success(categoryVoList);
    }

    /**
     * 转换 categoryList 为 categoryVoList
     * @param categoryList categoryList
     * @return categoryVoList
     */
    private List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        categoryList.forEach(category -> {
            categoryVoList.add (copyOne(category) );
        });

        return categoryVoList;
    }


    /**
     * 转换 category 为 categoryVo
     * @param category category
     * @return categoryVo
     */
    private CategoryVo copyOne(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);

        return categoryVo;
    }
}
