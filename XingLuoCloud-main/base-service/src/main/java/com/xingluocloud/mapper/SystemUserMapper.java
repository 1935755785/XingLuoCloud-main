package com.xingluocloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingluocloud.entity.base.system.SystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: 系统用户 Mapper 接口
 * @Author: SJF
 * @Date: 2023/5/24
 **/
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {
}
