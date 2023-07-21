package com.xingluocloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xingluocloud.entity.base.system.SystemRole;
import com.xingluocloud.result.CommonResult;
import com.xingluocloud.service.system.SystemRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Description: 系统角色请求处理器
 * @Author: SJF
 * @Date: 2023/7/18
 **/
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/base/system/role")
public class SystemRoleController {

    @Resource
    private SystemRoleService systemRoleService;

    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public CommonResult<List<SystemRole>> findAll() {
        List<SystemRole> list = systemRoleService.list(null);
        return CommonResult.ok(list);
    }

    @ApiOperation("分页查询所有角色")
    @GetMapping("/findAll/{current}/{size}")
    public CommonResult<Page<SystemRole>> pageQuery(@PathVariable("current") Integer current,
                                                    @PathVariable("size") Integer size,
                                                    @RequestBody SystemRole systemRole){

        Page<SystemRole> rolePage = new Page<>(current, size);
        LambdaQueryWrapper<SystemRole> wrapper = new LambdaQueryWrapper<>();
        String queryRoleName = systemRole.getRoleName();
        // 角色名进行模糊查询
        wrapper.like(!StringUtils.isEmpty(queryRoleName),SystemRole::getRoleName,queryRoleName);
        Page<SystemRole> page = systemRoleService.page(rolePage,wrapper);
        return CommonResult.ok(page);
    }

    @ApiOperation("新增角色")
    @PostMapping("/save")
    public CommonResult<Object> save(@RequestBody SystemRole systemRole){
        boolean save = systemRoleService.save(systemRole);
        if (save) {
            return CommonResult.ok().message("添加成功");
        }
        return CommonResult.fail();
    }

    @ApiOperation("修改角色")
    @PutMapping("/update")
    public CommonResult<Object> update(@RequestBody SystemRole systemRole) {
        boolean update = systemRoleService.updateById(systemRole);
        if (update) {
            return CommonResult.ok();
        }
        return CommonResult.fail();
    }

    @ApiOperation("根据角色 id 删除")
    @DeleteMapping("/remove/{id}")
    public CommonResult<Object> remove(@PathVariable Long id) {
        boolean remove = systemRoleService.removeById(id);
        if (remove) {
            return CommonResult.ok().message("删除成功");
        }
        return CommonResult.fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/batchRemove")
    public CommonResult<Object> batchRemove(@RequestBody List<Long> idList) {
        boolean removeBatchByIds = systemRoleService.removeBatchByIds(idList);
        if (removeBatchByIds) {
            return CommonResult.ok();
        }
        return CommonResult.fail();
    }

    @ApiOperation("根据角色 id 查询角色详细信息")
    @GetMapping("/get/{id}")
    public CommonResult<SystemRole> getRoleById(@PathVariable Long id){
        SystemRole role = systemRoleService.getById(id);
        if (role != null) {
            return CommonResult.ok(role).message("修改成功");
        }
        return CommonResult.fail();
    }

//    @ApiOperation(value = "根据用户获取角色数据")
//    @GetMapping("/beforeAssign/{userId}")
//    public CommonResult<Map<String, List<SystemRole>>> beforeAssign(@PathVariable Long userId) {
//        Map<String, List<SystemRole>> roleMap = roleService.findRoleByUserId(userId);
//        return CommonResult.ok(roleMap);
//    }

//    @ApiOperation(value = "根据用户分配角色")
//    @PostMapping("/doAssign")
//    public CommonResult<Object> doAssign(@RequestBody AssignRoleVo assignRoleVo) {
//        roleService.doAssign(assignRoleVo);
//        return CommonResult.ok();
//    }
}
