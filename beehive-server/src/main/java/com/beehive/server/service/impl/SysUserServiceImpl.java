package com.beehive.server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
;
import com.beehive.model.entity.*;
import com.beehive.model.mapper.*;
import com.beehive.server.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用户 业务层处理
 *
 * @author beehive
 */
@Service

public class SysUserServiceImpl implements ISysUserService
{


    @Autowired
    private  SysUserMapper sysUserMapper;

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName)
    {
        return sysUserMapper.selectOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUserName,userName));
    }


}
