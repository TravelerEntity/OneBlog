package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.CategoryVo;

/**
 * Created by Lee Yian on 2023/4/17 14:55
 */
public interface CategoryService {

    /**
     * 返回 category Vo by category id
     * @param id category id
     * @return CategoryVo
     */
    CategoryVo findCategoryVoById(Long id);

    /**
     * 获取全部的 Category
     * @return R
     */
    R findAll();

    /**
     * 获取全部的 categories detail
     * @return R
     */
    R findAllDetail();
}
