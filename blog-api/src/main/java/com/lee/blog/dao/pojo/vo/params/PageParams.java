package com.lee.blog.dao.pojo.vo.params;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/4 17:17
 * pagination VO
 */
@Data
public class PageParams {
    // which page
    private int page = 1;

    // how many records
    private int pageSize = 10;

    // 类别 id
    private Long categoryId;

    // 标签 id
    private Long tagId;

    // 排序方式
    private String sort;

    // 年，文章归档用
    private String year;

    // 月，文章归档用
    private String month;

    // 如果 month == 1，把它变成 01
    public String getMonth() {
        if (this.month != null && this.month.length() == 1){
            return "0"+this.month;
        }
        return month;
    }
}
