package com.xingluocloud.service.device.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingluocloud.entity.base.device.Device;
import com.xingluocloud.entity.base.device.DeviceUtils;

import com.xingluocloud.mapper.DeviceMapper;
import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.device.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("deviceService")

public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService{
    @Autowired
    private DeviceMapper deviceMapper;
    private static final Integer IS_DELETE=1;
    /**
     * 分页模糊查询
     * @param current
     * @param size
     * @param device
     * @return
     */
    @Override
    public CommonResult<Page<Device>> selectAll(Integer current, Integer size, Device device) {

       Page<Device> page=new Page<>(current, size);
        LambdaQueryWrapper<Device> wrapper = new LambdaQueryWrapper<>();
        //名称
        wrapper.like(!StringUtils.isEmpty(device.getDevName()), Device::getDevName,device.getDevName());
        //编号
        wrapper.like(!StringUtils.isEmpty(device.getDevId()), Device::getDevId,device.getDevId());
        //类型
        wrapper.like(!StringUtils.isEmpty(device.getDevType()), Device::getDevType,device.getDevType());
        Page<Device> devicePage = this.page(page, wrapper);
        return CommonResult.ok(devicePage);
    }

    /**
     * 根据设备编号查找详细信息
     * @param devId
     * @return
     */
    @Override
    public CommonResult<Device> selectByDevId(Long devId) {
        LambdaQueryWrapper<Device> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Device::getDevId,devId);
        Device device = deviceMapper.selectOne(wrapper);
        return CommonResult.ok(device);
    }

    /**
     * 新增设备
     * @param device
     * @return
     */
    @Override
    public CommonResult<Device> insert(Device device) {
        if (Objects.isNull(device.getDevId())){
            device.setDevId(DeviceUtils.generateDeviceNumber());
        }
        this.save(device);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<Device> updateByDevId(Device device) {
        this.updateById(device);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<Device> deleteByIds(List<Long> idList) {
        this.removeByIds(idList);
        return CommonResult.ok();
    }


}
