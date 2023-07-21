package com.xingluocloud.entity.base.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xingluocloud.entity.common.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @Author: SJF
 * @Date: 2023/5/22
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "系统角色")
@TableName(value = "sys_role")
public class SystemRole extends Base {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty(value = "角色编码")
    @TableField("role_code")
    private String roleCode;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

}
