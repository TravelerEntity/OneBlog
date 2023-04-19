package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
