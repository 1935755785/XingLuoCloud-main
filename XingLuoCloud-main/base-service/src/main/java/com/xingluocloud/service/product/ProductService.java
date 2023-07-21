package com.xingluocloud.service.product;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.xingluocloud.entity.base.product.Product;
import com.xingluocloud.result.CommonResult;

import java.util.List;

/**
 * (Material)表服务接口
 *
 * @author makejava
 * @since 2023-07-19 10:24:58
 */
public interface ProductService extends IService<Product> {


    CommonResult<Page<Product>> selectAll(Integer current, Integer size, Product product);

    CommonResult<Product> selectByProId(Long proId);

    CommonResult<Product> insert(Product product);

    CommonResult<Product> updateByProId(Product product);

    CommonResult<Product> deleteByIds(List<Long> idList);
}

