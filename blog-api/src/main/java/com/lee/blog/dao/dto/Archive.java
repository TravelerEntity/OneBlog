package com.lee.blog.dao.dto;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/5 16:41
 * 文章归档 DTO 对象
 */

@Data
public class Archive {
    private String year;

    private String month;

    private String count;
}
