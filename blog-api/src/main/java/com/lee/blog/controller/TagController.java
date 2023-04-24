package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lee Yian on 2023/4/5 11:17
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * 获取热门标签
     * @return 热门标签
     */
    @GetMapping("hot")
    public R hot(){
        // 返回 6 个热门标签
        int limit = 6;
        return tagService.hots(limit);
    }

    /**
     * 返回所有的标签
     * @return tag list
     */
    @GetMapping
    public R tags(){
        return tagService.findAll();
    }

    /**
     * 返回所有的标签 detail
     * @return tag list
     */
    @GetMapping("detail")
    public R tagDetails(){
        return tagService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public R tagDetailId(@PathVariable("id") Long tagId){
        return tagService.findTagById(tagId);
    }

}
