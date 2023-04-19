package com.lee.blog.controller;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.params.CommentParam;
import com.lee.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee Yian on 2023/4/17 19:38
 */
@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * 返回评论
     * @param articleId articleId
     * @return R
     */
    @GetMapping("article/{articleId}")
    public R comments(@PathVariable Long articleId){
        return commentService.findCommentsByArticleId(articleId);
    }

    /**
     * 增加新评论
     * @param commentParam 评论参数
     * @return R
     */
    @PostMapping("create/change")
    public R create(@RequestBody CommentParam commentParam){
        return commentService.comment(commentParam);
    }
}
