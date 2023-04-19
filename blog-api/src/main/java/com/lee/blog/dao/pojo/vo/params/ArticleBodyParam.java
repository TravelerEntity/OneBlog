package com.lee.blog.dao.pojo.vo.params;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/18 21:22
 * body param 与前端交互
 */

@Data
public class ArticleBodyParam {
    private String content;

    private String contentHtml;
}
