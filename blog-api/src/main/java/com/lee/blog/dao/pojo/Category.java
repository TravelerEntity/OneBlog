package com.lee.blog.dao.pojo;

import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/16 15:00
 */
@Data
public class Category {
    private Long id;
    private String avatar;
    private String categoryName;
    private String description;
}
