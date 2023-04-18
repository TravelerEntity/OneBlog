package com.lee.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.dao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Lee Yian on 2023/4/17 19:47
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
