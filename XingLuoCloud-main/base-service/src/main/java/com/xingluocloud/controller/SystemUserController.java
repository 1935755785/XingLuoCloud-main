package com.xingluocloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingluocloud.entity.base.system.SystemUser;
import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.system.SystemRoleService;
import com.xingluocloud.service.system.SystemUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 系统用户请求处理器
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@RestController
@Api(tags = "用户管理接口")
@RequestMapping("/admin/system/user")
public class SystemUserController {
    @Resource
    private SystemUserService systemUserService;

    @Resource
    private SystemRoleService systemRoleService;

    @ApiOperation("查询所有用户")
    @GetMapping("/findAll")
    public CommonResult<List<SystemUser>> findAl(){
        List<SystemUser> list = systemUserService.list();
        return CommonResult.ok(list);
    }


    @ApiOperation("分页查询满足条件的用户")
    @GetMapping("/findAll/{current}/{size}")
    public CommonResult<Page<SystemUser>> pageQuery(@PathVariable Integer current,
                                                    @PathVariable Integer size,
                                                    @RequestBody SystemUser systemUser) {
        Page<SystemUser> page = new Page<>(current, size);
        LambdaQueryWrapper<SystemUser> wrapper = new LambdaQueryWrapper<>();
        /*
          :支持根据用户名或者姓名查询
         */
        String userName = systemUser.getUserName();
        String name = systemUser.getName();

        if(!StringUtils.isEmpty(name)){
            wrapper.like(SystemUser::getName,name)
                    .or()
                    .like(SystemUser::getUserName,userName);
        }
        Page<SystemUser> userPage = systemUserService.page(page, wrapper);
        if(userPage != null){
            List<SystemUser> list = userPage.getRecords();
            // 获取每个用户对应的角色
            List<SystemUser> userList = systemRoleService.getAssignedRole(list);
            userPage.setRecords(userList);
            return CommonResult.ok(userPage);
        }
        return CommonResult.fail();

    }

    @ApiOperation("新增用户")
    @PostMapping("/save")
    public CommonResult<Object> save(@RequestBody SystemUser user) {
        boolean save = systemUserService.save(user);
        if (save) {
            return CommonResult.ok();
        }
        return CommonResult.fail();
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public CommonResult<Object> update(@RequestBody SystemUser user) {
        boolean update = systemUserService.updateById(user);
        if (update) {
            return CommonResult.ok();
        }
        return CommonResult.fail();
    }

    @ApiOperation("根据用户 id 查询用户")
    @GetMapping("/get/{id}")
    public CommonResult<SystemUser> getById(@PathVariable Long id) {
        SystemUser user = systemUserService.getById(id);
        if (user != null) {
            return CommonResult.ok(user);
        }
        return CommonResult.fail();
    }

    @ApiOperation("根据用户 id 删除用户")
    @DeleteMapping("/delete/{id}")
    public CommonResult<Object> delete(@PathVariable Long id) {
        boolean remove = systemUserService.removeById(id);
        if (remove) {
            return CommonResult.ok();
        }
        return CommonResult.fail();
    }
}
