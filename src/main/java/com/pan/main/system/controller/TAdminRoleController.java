package com.pan.main.system.controller;

import com.pan.main.system.entity.TAdminRole;
import com.pan.main.system.service.TAdminRoleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (TAdminRole)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-05-01 19:56:22
 */
@RestController
@RequestMapping("/adrole")
public class TAdminRoleController {
  
    @Autowired
    TAdminRoleService tAdminRoleService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tAdminRole 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R<IPage<TAdminRole>>  selectAll(Page<TAdminRole> page, TAdminRole tAdminRole) {
        return R.ok (this.tAdminRoleService.page(page, new QueryWrapper<>(tAdminRole)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R<TAdminRole> selectOne(@PathVariable Serializable id) {
        return R.ok(this.tAdminRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tAdminRole 实体对象
     * @return 新增结果
     */
    @PostMapping
    @CrossOrigin
    public R<Long> insert(@RequestBody TAdminRole tAdminRole) {
        boolean rs = this.tAdminRoleService.save(tAdminRole);
        
        return R.ok(rs?tAdminRole.getAdminId():0);
    }

    /**
     * 修改数据
     *
     * @param tAdminRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R<Long>  update(@RequestBody TAdminRole tAdminRole) {
        boolean rs = this.tAdminRoleService.updateById(tAdminRole);
        return R.ok(tAdminRole.getAdminId());
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @CrossOrigin
    public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.tAdminRoleService.removeByIds(idList));
    }
}