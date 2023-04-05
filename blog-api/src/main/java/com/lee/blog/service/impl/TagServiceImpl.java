package com.lee.blog.service.impl;

import com.lee.blog.dao.mapper.TagMapper;
import com.lee.blog.dao.pojo.Tag;
import com.lee.blog.dao.pojo.vo.TagVo;
import com.lee.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 21:13
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagmapper;

    // 根据文章 id 查询标签
    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tagList = tagmapper.findTagsByArticleId(articleId);
        return copyList(tagList);
    }

    private List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<>();
        // 遍历复制
        tagList.forEach(tag -> tagVoList.add(copyOne(tag) ) );
        return tagVoList;
    }

    private TagVo copyOne(Tag tag) {
        TagVo tagVo = new TagVo();
        // 使用工具类进行复制属性, 它可以自动复制相同名字的属性
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
}
