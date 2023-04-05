package com.lee.blog.service;

import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.PageParams;
import org.springframework.stereotype.Service;

/**
 * Created by Lee Yian on 2023/4/4 17:36
 */

public interface ArticleService {

    // TODO 完成接口实现
    R listArticle(PageParams pageParams);

}
