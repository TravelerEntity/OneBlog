package com.lee.blog.service;

import com.lee.blog.dao.mapper.TagMapper;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 20:58
 */

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    R hots(int limit);
}
