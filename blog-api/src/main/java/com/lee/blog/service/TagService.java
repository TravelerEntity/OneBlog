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

    /**
     * 通过 article id 获取 tags
     * @param articleId articleId
     * @return R
     */
    List<TagVo> findTagsByArticleId(Long articleId);


    /**
     * 返回 前 limit 个热门的 tag
     * @param limit 前几个
     * @return R
     */
    R hots(int limit);

    /**
     * 获取所有的 tag，精简版
     * @return R
     */
    R findAll();

    /**
     * 返回所有的 tag
     * @return R
     */
    R findAllDetail();

    /**
     * 根据 id 查找 tag
     * @param tagId tagId
     * @return R
     */
    R findTagById(Long tagId);
}
