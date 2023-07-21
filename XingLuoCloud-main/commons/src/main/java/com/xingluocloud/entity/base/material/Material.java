package com.xingluocloud.entity.base.material;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

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
public class Material extends Base {
    

    //物料id
    private String matId;
    //物料规格
    private String matSize;
    //供应商
    private String matSupplier;
    //单价
    private BigDecimal matPrice;
    //单位
    private String matUnit;
    //存储位置
    private String matStorage;
    //库存数量
    private Integer matStock;
    //最大库存
    private Integer matMax;
    //最小库存
    private Integer matMin;
    //物料名称
    private String matName;

}

