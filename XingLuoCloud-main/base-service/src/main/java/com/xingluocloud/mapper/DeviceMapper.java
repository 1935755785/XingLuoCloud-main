package com.xingluocloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xingluocloud.entity.base.device.Device;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Device)表数据库访问层
 *
 * @since 2023-07-19 10:24:57
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

}

