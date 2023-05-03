package com.lee.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.admin.pojo.Admin;
import com.lee.blog.admin.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Lee Yian on 2023/5/1 17:41
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from ms_permission where id in " +
                "(select permission_id from ms_admin_permission where admin_id = #{adminId} ) " )
    List<Permission> findPermissionListByAdminId(Long adminId);
}
