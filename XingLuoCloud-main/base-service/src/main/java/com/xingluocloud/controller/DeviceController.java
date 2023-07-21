package com.xingluocloud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingluocloud.entity.base.device.Device;
import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.device.DeviceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("device")
public class DeviceController {
//    服务对象
    @Resource
    private DeviceService deviceService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param device 查询实体
     * @return 所有数据
     */
    @GetMapping("/findAll/{current}/{size}")
    public CommonResult<Page<Device>> selectAll(@PathVariable("current") Integer current,
                                                 @PathVariable("size") Integer size,
                                                 @RequestBody Device device) {
        return deviceService.selectAll(current,size,device);
    }

    /**
     * 通过产品编号查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{devId}")
    public CommonResult<Device> selectByDevId(@PathVariable  Long devId) {
        return deviceService.selectByDevId(devId);
    }

    /**
     * 新增数据
     *
     * @param device 实体对象
     * @return 新增结果
     */
    @PostMapping("save")
    public CommonResult<Device> insert(@RequestBody Device device) {
        return deviceService.insert(device);
    }

    /**
     * 修改数据
     *
     * @param device 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult<Device> updateByDevId(@RequestBody Device device) {
        return deviceService.updateByDevId(device);
    }
//    public CommonResult<Material> updateByMatId(@RequestBody Material material) {
//        return materialService.updateByMatId(material);
//    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public CommonResult<Device> deleteByIds(@RequestParam("idList") List<Long> idList) {
        return deviceService.deleteByIds(idList);
    }
//    public CommonResult<Material> deleteByIds(@RequestParam("idList") List<Long> idList) {
//        return materialService.deleteByIds(idList);
//    }
}

