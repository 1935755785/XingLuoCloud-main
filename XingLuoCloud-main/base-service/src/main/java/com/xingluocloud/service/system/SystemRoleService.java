package com.xingluocloud.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xingluocloud.entity.base.system.SystemRole;
import com.xingluocloud.entity.base.system.SystemUser;

import java.util.List;
import java.util.Map;

/**
 * @Description: 系统角色服务接口
 * @Author: SJF
 * @Date: 2023/7/17
 **/
public interface SystemRoleService extends IService<SystemRole> {
    /**
     * 根据用户获取已分配的角色信息
     */
    List<SystemUser> getAssignedRole(List<SystemUser> list);
}
