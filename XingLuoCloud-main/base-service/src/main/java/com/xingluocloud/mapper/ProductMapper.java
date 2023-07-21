package com.xingluocloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.xingluocloud.entity.base.product.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-19 10:24:57
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}

