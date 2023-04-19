package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.params.CommentParam;

/**
 * Created by Lee Yian on 2023/4/17 19:43
 */
public interface CommentService {


    /**
     * 根据文章 id 查询文章的评论
     * @param articleId articleId
     * @return R
     */
    R findCommentsByArticleId(Long articleId);

    /**
     * 发布评论
     * @param commentParam 评论参数，包含：articleId, content, parentId, toUserId
     * @return R
     */
    R comment(CommentParam commentParam);
}
