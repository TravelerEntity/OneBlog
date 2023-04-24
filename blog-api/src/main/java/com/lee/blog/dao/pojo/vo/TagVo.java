package com.lee.blog.dao.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created by Lee Yian on 2023/4/4 20:24
 */

@Data
@TableName("ms_tag")
public class TagVo {

    private Long id;

    private String tagName;

    private String avatar;
}
