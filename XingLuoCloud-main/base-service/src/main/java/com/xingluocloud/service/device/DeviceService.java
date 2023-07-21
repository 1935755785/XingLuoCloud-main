package com.xingluocloud.service.device;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xingluocloud.entity.base.device.Device;
import com.xingluocloud.result.CommonResult;


import java.util.List;

public interface DeviceService extends IService<Device>{
    CommonResult<Page<Device>> selectAll(Integer current, Integer size, Device device);

    CommonResult<Device> selectByDevId(Long DevId);

    CommonResult<Device> insert(Device device);

    CommonResult<Device> updateByDevId(Device device);

    CommonResult<Device> deleteByIds(List<Long> idList);
}
