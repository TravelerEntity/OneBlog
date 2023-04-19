package com.lee.blog.dao.pojo.vo.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lee.blog.dao.pojo.vo.CategoryVo;
import com.lee.blog.dao.pojo.vo.TagVo;
import lombok.Data;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/18 21:20
 * 与前端交互的文章对象
 */
@Data
public class ArticleParam {
    private String title;

    private Long id;

    @JsonProperty("body")
    private ArticleBodyParam bodyParam;

    @JsonProperty("category")
    private CategoryVo categoryVo;

    private String summary;

    @JsonProperty("tags")
    private List<TagVo> tagVoList;
}
