package com.xingluocloud.service.material.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingluocloud.entity.base.material.Material;
import com.xingluocloud.entity.base.material.MaterialUtils;
import com.xingluocloud.entity.base.system.SystemRole;
import com.xingluocloud.mapper.MaterialMapper;
import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * (Material)表服务实现类
 *
 * @author makejava
 * @since 2023-07-19 10:24:58
 */
@Service("materialService")
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;

    private static final Integer IS_DELETE=1;
    /**
     * 分页模糊查询
     * @param current
     * @param size
     * @param material
     * @return
     */
    @Override
    public CommonResult<Page<Material>> selectAll(Integer current, Integer size, Material material) {

        Page<Material> page = new Page<>(current, size);
        LambdaQueryWrapper<Material> wrapper = new LambdaQueryWrapper<>();
        //名称
        wrapper.like(!StringUtils.isEmpty(material.getMatName()), Material::getMatName,material.getMatName());
        //编号
        wrapper.like(!StringUtils.isEmpty(material.getMatId()), Material::getMatId,material.getMatId());
        //规格尺寸
        wrapper.like(!StringUtils.isEmpty(material.getMatSize()), Material::getMatSize,material.getMatSize());
        Page<Material> materialPage = this.page(page, wrapper);
        return CommonResult.ok(materialPage);
    }

    /**
     * 根据物料编号查找详细信息
     * @param matId
     * @return
     */
    @Override
    public CommonResult<Material> selectByMatId(Long matId) {
        LambdaQueryWrapper<Material> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Material::getMatId,matId);
        Material material = materialMapper.selectOne(wrapper);
        return CommonResult.ok(material);
    }

    /**
     * 新增物料
     * @param material
     * @return
     */
    @Override
    public CommonResult<Material> insert(Material material) {
        if (Objects.isNull(material.getMatId())){
            material.setMatId(MaterialUtils.generateMaterialNumber());
        }
        this.save(material);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<Material> updateByMatId(Material material) {
        this.updateById(material);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<Material> deleteByIds(List<Long> idList) {
        this.removeByIds(idList);
        return CommonResult.ok();
    }


}

