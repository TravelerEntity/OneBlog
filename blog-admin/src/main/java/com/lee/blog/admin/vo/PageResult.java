package com.lee.blog.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Lee Yian on 2023/5/1 14:17
 */
@Data
public class PageResult<T> {
    private List<T> list;

    private Long total;
}
