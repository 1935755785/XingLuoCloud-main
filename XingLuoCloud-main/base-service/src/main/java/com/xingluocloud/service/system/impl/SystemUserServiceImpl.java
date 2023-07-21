package com.xingluocloud.service.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingluocloud.entity.base.system.SystemUser;
import com.xingluocloud.mapper.SystemUserMapper;
import com.xingluocloud.service.system.SystemUserService;
import org.springframework.stereotype.Service;

/**
 * @Description: 系统用户服务接口实现类
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements SystemUserService {
}
