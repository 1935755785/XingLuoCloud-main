package com.xingluocloud.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xingluocloud.entity.base.product.Product;
import com.xingluocloud.entity.base.product.ProductUtils;
import com.xingluocloud.mapper.ProductMapper;
import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2023-07-19 10:24:58
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    private static final Integer IS_DELETE=1;
    /**
     * 分页模糊查询
     * @param current
     * @param size
     * @param product
     * @return
     */
    @Override
    public CommonResult<Page<Product>> selectAll(Integer current, Integer size, Product product) {

        Page<Product> page = new Page<>(current, size);
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        //名称
        wrapper.like(!StringUtils.isEmpty(product.getProName()), Product::getProName,product.getProName());
        //编号
        wrapper.like(!StringUtils.isEmpty(product.getProId()), Product::getProId,product.getProId());
        //规格尺寸
        wrapper.like(!StringUtils.isEmpty(product.getProSize()), Product::getProSize,product.getProSize());
        Page<Product> productPage = this.page(page, wrapper);
        return CommonResult.ok(productPage);
    }

    /**
     * 根据产品编号查找详细信息
     * @param proId
     * @return
     */
    @Override
    public CommonResult<Product> selectByProId(Long proId) {
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getProId,proId);
        Product product = productMapper.selectOne(wrapper);
        return CommonResult.ok(product);
    }

    /**
     * 新增产品
     * @param product
     * @return
     */
    @Override
    public CommonResult<Product> insert(Product product) {
        if (Objects.isNull(product.getProId())){
            product.setProId(ProductUtils.generateProductNumber());
        }
        this.save(product);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<Product> updateByProId(Product product) {
        this.updateById(product);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<Product> deleteByIds(List<Long> idList) {
        this.removeByIds(idList);
        return CommonResult.ok();
    }


}

