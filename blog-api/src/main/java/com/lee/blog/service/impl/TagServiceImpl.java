package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lee.blog.dao.mapper.TagMapper;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.Tag;
import com.lee.blog.dao.pojo.vo.TagVo;
import com.lee.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 21:13
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagmapper;

    // 查询 热门标签
    // 至于为什么这里采用单表查两次，而不是多表联查，根据网上的搜索结果，为了数据库的效率，单表查对数据库的压力更小
    @Override
    public R hots(int limit) {
        // 1. 最热标签指的是某个标签下所拥有的文章最多
        // 2. 先获取到热门标签的 id，所以先按照 tag_id 分组，然后计数，再降序排，并取前 limit 个
        List<Long> tagIdList = tagmapper.findHotTagIds(limit);
        // 2.1 非空校验，防止出现空的 idList
        if(CollectionUtils.isEmpty(tagIdList) ){
            // 如果 idList 是空的，就直接返回
            return R.success(Collections.emptyList());
        }
        // 3 接着用 id 去查具体的标签对象（tagName, tagId)
        // List<TagVo> tagList = tagmapper.findTagsByTagIds(tagIdList);
        // 3.1
        List<Tag> tagList = tagmapper.selectBatchIds(tagIdList);

        return R.success(tagList);
    }

    @Override
    public R findAll() {
        // 直接传 null 也表示不需要附加任何查询条件
        List<Tag> tagList = tagmapper.selectList(null);
        List<TagVo> tagVoList = copyList(tagList);

        return R.success(tagVoList);

    }

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
