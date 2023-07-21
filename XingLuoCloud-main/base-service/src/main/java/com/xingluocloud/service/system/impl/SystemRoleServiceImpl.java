package com.xingluocloud.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingluocloud.entity.base.system.SystemRole;
import com.xingluocloud.entity.base.system.SystemUser;
import com.xingluocloud.mapper.SystemRoleMapper;
import com.xingluocloud.service.system.SystemRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 系统角色服务接口实现类
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper,SystemRole> implements SystemRoleService {
    @Override
    public List<SystemUser> getAssignedRole(List<SystemUser> list) {
        return null;
    }
}
