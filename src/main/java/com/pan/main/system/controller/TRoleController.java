package com.pan.main.system.controller;

import com.pan.main.system.entity.TRole;
import com.pan.main.system.service.TRoleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (TRole)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Api(tags = "系统——角色管理")
@RestController
@RequiresPermissions("role:*")
@RequestMapping("/role")
public class TRoleController {
  
    @Autowired
    TRoleService tRoleService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R<IPage<TRole>>  selectAll(Page<TRole> page, TRole tRole) {
        return R.ok (this.tRoleService.page(page, new QueryWrapper<>(tRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R<TRole> selectOne(@PathVariable Serializable id) {
        return R.ok(this.tRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    @CrossOrigin
    public R<Long> insert(@RequestBody TRole tRole) {
        boolean rs = this.tRoleService.createRole(tRole);
        
        return R.ok(rs?tRole.getRoleId():0);
    }

    /**
     * 修改数据
     *
     * @param tRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R<Long>  update(@RequestBody TRole tRole) {
        boolean rs = this.tRoleService.updateRole(tRole);
        return R.ok(tRole.getRoleId());
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @CrossOrigin
    public R<Boolean> delete(@RequestParam("idList") Long idList) {
        return R.ok(this.tRoleService.deleteRoles(idList));
    }
}