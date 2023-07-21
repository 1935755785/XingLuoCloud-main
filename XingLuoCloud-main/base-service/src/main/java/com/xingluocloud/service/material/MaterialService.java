package com.xingluocloud.service.material;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.xingluocloud.entity.base.material.Material;
import com.xingluocloud.result.CommonResult;

import java.util.List;

/**
 * (Material)表服务接口
 *
 * @author makejava
 * @since 2023-07-19 10:24:58
 */
public interface MaterialService extends IService<Material> {


    CommonResult<Page<Material>> selectAll(Integer current, Integer size, Material material);

    CommonResult<Material> selectByMatId(Long matId);

    CommonResult<Material> insert(Material material);

    CommonResult<Material> updateByMatId(Material material);

    CommonResult<Material> deleteByIds(List<Long> idList);
}

