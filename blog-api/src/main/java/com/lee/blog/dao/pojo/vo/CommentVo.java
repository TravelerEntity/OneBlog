package com.lee.blog.dao.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/17 20:08
 */
@Data
public class CommentVo {
      /*
        查询评论列表
        我们需要返回：id, author, content, children, createDate, level, toUser
        1. 先查询评论，
        2. 获取再根据的 author id 查询用户，parentId 查询父评论
     */

    /*
        对于 Long 类型的数据，在序列化为 JSON 时，会被转为 js 的 Number 类型
        但是雪花 id 的长度超出了 Number 类型，所以就会出现值不一样的问题
        因此我们需要使用 @JsonSerialize(using = ToStringSerializer.class)
        注解来使得我们的 Long 型数据以 String 格式被转成 JSON
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private UserVo author;

    private String content;

    @JsonProperty("childrens")
    // @JSONField(name = "childrens")
    private List<CommentVo> children;

    private String createDate;

    // 评论级别，默认 1，子评论 2
    private Integer level;

    private UserVo toUser;

}
