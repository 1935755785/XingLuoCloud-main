package com.xingluocloud.entity.base.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xingluocloud.entity.common.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description: 系统用户实体类
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@TableName(value = "sys_user")
@ApiModel(description = "系统用户")
public class SystemUser extends Base {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "手机")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;


    @ApiModelProperty(value = "状态（1：正常 0：停用）")
    @TableField("status")
    private Integer status;

    @TableField(exist = false)
    private SystemRole userRole;
}
