package com.xingluocloud.entity.base.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xingluocloud.entity.common.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 用户角色关联表
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "系统用户角色中间表")
@TableName("sys_user_role")
public class SystemUserAndRole extends Base {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Long userId;
}
