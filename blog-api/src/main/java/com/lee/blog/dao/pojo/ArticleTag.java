package com.lee.blog.dao.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/18 21:52
 */
@Data
@TableName("ms_article_tag")
public class ArticleTag {

    private Long id;

    private Long articleId;

    private Long tagId;
}
