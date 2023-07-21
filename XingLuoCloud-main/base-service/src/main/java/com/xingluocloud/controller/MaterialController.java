package com.xingluocloud.controller;





import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.xingluocloud.entity.base.material.Material;

import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.material.MaterialService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Material)表控制层
 *
 * @author makejava
 * @since 2023-07-19 10:24:54
 */
@RestController
@RequestMapping("material")
public class MaterialController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialService materialService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param material 查询实体
     * @return 所有数据
     */
    @GetMapping("/findAll/{current}/{size}")
    public CommonResult<Page<Material>> selectAll(@PathVariable("current") Integer current,
                                            @PathVariable("size") Integer size,
                                            @RequestBody Material material) {
        return materialService.selectAll(current,size,material);
    }

    /**
     * 通过物料编号查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{matId}")
    public CommonResult<Material> selectByMatId(@PathVariable  Long matId) {
        return materialService.selectByMatId(matId);
    }

    /**
     * 新增数据
     *
     * @param material 实体对象
     * @return 新增结果
     */
    @PostMapping("save")
    public CommonResult<Material> insert(@RequestBody Material material) {
        return materialService.insert(material);
    }

    /**
     * 修改数据
     *
     * @param material 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult<Material> updateByMatId(@RequestBody Material material) {
        return materialService.updateByMatId(material);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public CommonResult<Material> deleteByIds(@RequestParam("idList") List<Long> idList) {
        return materialService.deleteByIds(idList);
    }
}

