package com.lee.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.dao.pojo.Tag;
import com.lee.blog.dao.pojo.vo.TagVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/4 16:58
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 使用 articleId 查询其所属的标签
     * @param articleId 文章 id
     * @return tags
     */
    List<Tag> findTagsByArticleId(Long articleId);


    /**
     * 返回前 limit 个热门标签的 Id，热门标签是指拥有文章最多的标签
     * @param limit 多少条记录
     * @return tagIds
     */
    List<Long> findHotTagIds(int limit);

    List<TagVo> findTagsByTagIds(List<Long> tagIdList);
}
