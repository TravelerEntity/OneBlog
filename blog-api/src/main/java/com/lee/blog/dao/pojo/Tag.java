package com.lee.blog.dao.pojo;

import lombok.Data;

@Data
public class Tag {

    private Long id;

    // 标签图标
    private String avatar;

    private String tagName;

}

