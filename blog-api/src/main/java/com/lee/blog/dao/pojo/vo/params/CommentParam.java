package com.lee.blog.dao.pojo.vo.params;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/18 15:57
 * 评论参数对象
 */
@Data
public class CommentParam {
    private Long articleId;

    private String content;

    // 前端会给我们传来 parent，为了避免歧义我们的属性使用 parentId 命名，
    // 同时，使用注解绑定 parent 和 parentId
    @JsonProperty("parent")
    private Long parentId;

    private Long toUserId;
}
