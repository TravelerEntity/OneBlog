package com.lee.blog.admin.service;

import com.lee.blog.admin.model.params.PageParam;
import com.lee.blog.admin.vo.PermissionVo;
import com.lee.blog.admin.vo.R;

/**
 * Created by Lee Yian on 2023/4/30 21:05
 */
public interface PermissionService {


    /**
     * 返回 permission 表中的记录
     * @param pageParam 查询参数
     * @return R
     */
    R listPermission(PageParam pageParam);


    /**
     * 增加 permission 对象
     * @param PermissionVo PermissionVo
     * @return R
     */
    R add(PermissionVo PermissionVo);


    /**
     * 根据 permissionId 删除数据
     * @param permissionId permissionId
     * @return R
     */
    R delete(Long permissionId);

    /**
     * 更新 permission
     * @param permissionVo permissionVo
     * @return R
     */
    R update(PermissionVo permissionVo);
}
