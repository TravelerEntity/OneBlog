package com.lee.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/16 14:59
 */

@Data
@TableName("ms_article_body")
public class ArticleBody {
    @TableId
    private Long id;
    private String content;
    private String contentHtml;
    private String articleId;
}
