package com.xingluocloud.entity.base.product;

import com.xingluocloud.entity.common.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Material)表实体类
 *
 * @author makejava
 * @since 2023-07-19 09:50:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Base {


    //产品id
    private String proId;
    //产品规格
    private String proSize;
    //工艺路线
    private String proRout;
    //类型
    private String proType;
    //单位
    private String proUnit;
    //库存数量
    private Integer proStock;
    //最大库存
    private Integer proMax;
    //最小库存
    private Integer proMin;
    //产品名称
    private String proName;

}

