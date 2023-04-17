package com.lee.blog.service;

import com.lee.blog.dao.pojo.Category;
import com.lee.blog.dao.pojo.vo.CategoryVo;

/**
 * Created by Lee Yian on 2023/4/17 14:55
 */
public interface CategoryService {

    /**
     *
     * @param id
     * @return
     */
    CategoryVo findCategoryById(Long id);
}
