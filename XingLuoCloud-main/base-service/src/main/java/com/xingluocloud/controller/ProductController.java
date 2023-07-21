package com.xingluocloud.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.xingluocloud.entity.base.product.Product;

import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2023-07-19 10:24:54
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param product 查询实体
     * @return 所有数据
     */
    @GetMapping("/findAll/{current}/{size}")
    public CommonResult<Page<Product>> selectAll(@PathVariable("current") Integer current,
                                                 @PathVariable("size") Integer size,
                                                 @RequestBody Product product) {
        return productService.selectAll(current,size,product);
    }

    /**
     * 通过产品编号查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{proId}")
    public CommonResult<Product> selectByProId(@PathVariable  Long proId) {
        return productService.selectByProId(proId);
    }

    /**
     * 新增数据
     *
     * @param product 实体对象
     * @return 新增结果
     */
    @PostMapping("save")
    public CommonResult<Product> insert(@RequestBody Product product) {
        return productService.insert(product);
    }

    /**
     * 修改数据
     *
     * @param product 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult<Product> updateByProId(@RequestBody Product product) {
        return productService.updateByProId(product);
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
    public CommonResult<Product> deleteByIds(@RequestParam("idList") List<Long> idList) {
        return productService.deleteByIds(idList);
    }
//    public CommonResult<Material> deleteByIds(@RequestParam("idList") List<Long> idList) {
//        return materialService.deleteByIds(idList);
//    }
}

