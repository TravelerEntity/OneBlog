package com.lee.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lee.blog.dao.mapper.SysUserMapper;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.dao.pojo.vo.ErrorCode;
import com.lee.blog.dao.pojo.vo.UserVo;
import com.lee.blog.service.LoginService;
import com.lee.blog.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Lee Yian on 2023/4/4 21:42
 */
@Service
public class SysUserImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    LoginService loginService;

    @Override
    public SysUser findUserById(Long id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public SysUser findUser(String account, String password) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.eq(SysUser::getPassword,password);
        queryWrapper.select(SysUser::getAccount,SysUser::getId,SysUser::getAvatar,SysUser::getNickname);
        queryWrapper.last("limit 1");

        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public R findUserByToken(String token) {
        /*
            1. 校验 token 是否合法（不能为空，通过 check），redis 中是否存在
            2. 失败返回 fail
            3. 成功把 userJson 转成对象后直接返回
         */
        String sysUserJson = loginService.checkToken(token);
        if(StringUtils.isBlank(sysUserJson)) {
            return R.fail(ErrorCode.TOKEN_NOT_EXISTS.getCode(), ErrorCode.TOKEN_NOT_EXISTS.getMsg());
        }
        // 直接解析然后返回
        return R.success(JSON.parse(sysUserJson));
    }

    @Override
    public SysUser findUserByAccount(String account) {
        return sysUserMapper.selectOne(new QueryWrapper<SysUser>()
                .eq("account",account)
                .last("limit 1") );
    }

    @Override
    public void save(SysUser sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public UserVo findUserVoById(Long userId) {
        SysUser user = sysUserMapper.selectById(userId);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }
}
