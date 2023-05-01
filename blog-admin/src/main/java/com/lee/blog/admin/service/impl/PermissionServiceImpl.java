package com.lee.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.blog.admin.mapper.PermissionMapper;
import com.lee.blog.admin.model.params.PageParam;
import com.lee.blog.admin.pojo.Permission;
import com.lee.blog.admin.service.PermissionService;
import com.lee.blog.admin.vo.PageResult;
import com.lee.blog.admin.vo.PermissionVo;
import com.lee.blog.admin.vo.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lee Yian on 2023/4/30 21:06
 */

@Service
public class PermissionServiceImpl implements PermissionService {
    private PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public R listPermission(PageParam pageParam) {
        // TODO 实现查询 permission 表
        Page<Permission> page = new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());

        // 附加查询字段
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(pageParam.getQueryString() ) ){
            queryWrapper.eq(Permission::getName, pageParam.getQueryString() );
        }
        // 执行分页查询
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);

        // 构造返回的 data
        PageResult<Permission> pageResult = new PageResult<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(permissionPage.getTotal());

        return R.success(pageResult);
    }

    @Override
    public R add(PermissionVo permissionVo) {
        Permission permission = new Permission();

        // 把 vo 对象转换为数据库对象，准备持久化
        BeanUtils.copyProperties(permissionVo, permission);

        // 非空校验
        if(StringUtils.isEmpty(permissionVo.getName()) ){
            return R.fail(999,"请正确填写表单");
        }

        // 执行持久化
        permissionMapper.insert(permission);

        return R.success();
    }

    @Override
    public R delete(Long permissionId) {
        // permission id 不为空才执行持久化
        if (permissionId != null){
            // 执行持久化
            permissionMapper.delete(new LambdaQueryWrapper<Permission>().eq(Permission::getId, permissionId) );
            return R.success();
        }
        return R.fail(-991,"未知异常，删除失败");

    }

    @Override
    public R update(PermissionVo permissionVo) {
        Permission permission = new Permission();

        // 把 vo 对象转换为数据库对象，准备持久化
        BeanUtils.copyProperties(permissionVo, permission);

        // 非空校验
        if(StringUtils.isEmpty(permissionVo.getName()) ){
            return R.fail(999,"请正确填写表单");
        }

        // 执行持久化
        permissionMapper.update(permission, new LambdaQueryWrapper<Permission>().eq(Permission::getId, permissionVo.getId()) );

        return R.success();
    }
}
