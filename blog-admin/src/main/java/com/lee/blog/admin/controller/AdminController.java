package com.lee.blog.admin.controller;

import com.lee.blog.admin.model.params.PageParam;
import com.lee.blog.admin.service.PermissionService;
import com.lee.blog.admin.vo.PermissionVo;
import com.lee.blog.admin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lee Yian on 2023/4/29 14:24
 */

@RestController
@RequestMapping(value = "admin")
public class AdminController {
    private PermissionService permissionService;

    @Autowired
    AdminController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("permission/permissionList")
    public R permissionList(@RequestBody PageParam pageParam){
        return permissionService.listPermission(pageParam);
    }

    @PostMapping("permission/add")
    public R add(@RequestBody PermissionVo permissionVo){
        return permissionService.add(permissionVo);
    }

    @GetMapping("permission/delete/{permissionId}")
    public R delete(@PathVariable("permissionId")Long permissionId){
        return permissionService.delete(permissionId);
    }

    @PostMapping("permission/update")
    public R update(@RequestBody PermissionVo permissionVo){
        return permissionService.update(permissionVo);
    }
}
