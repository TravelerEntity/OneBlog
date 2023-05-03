package com.lee.blog.admin.model.params;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/30 21:13
 * 从前端接收的首页查询参数
 */

@Data
public class PageParam {
    private Integer currentPage;

    private Integer pageSize;

    private Integer total;

    // 查询字符串，关键词搜索
    private String queryString;
}
