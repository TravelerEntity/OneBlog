package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.CategoryVo;
import com.lee.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lee Yian on 2023/4/18 20:40
 */
@RestController
@RequestMapping("categorys")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public R categories(){
        return categoryService.findAll();
    }

    @GetMapping("detail")
    public R categoriesDetail(){
        return categoryService.findAllDetail();
    }

    /**
     * 通过 category id 获取 category
     * @param categoryId categoryId
     * @return categoryVo
     */
    @GetMapping("detail/{id}")
    public R categoryDetail(@PathVariable("id") Long categoryId){
        CategoryVo categoryVo = categoryService.findCategoryVoById(categoryId);
        return R.success(categoryVo);
    }

}
