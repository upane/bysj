package com.pan.main.system.controller;

import com.pan.main.system.entity.TRoleMenu;
import com.pan.main.system.service.TRoleMenuService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (TRoleMenu)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-05-01 19:56:22
 */
@RestController
@RequestMapping("/rolmenu")
public class TRoleMenuController {
  
    @Autowired
    TRoleMenuService tRoleMenuService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tRoleMenu 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R<IPage<TRoleMenu>>  selectAll(Page<TRoleMenu> page, TRoleMenu tRoleMenu) {
        return R.ok (this.tRoleMenuService.page(page, new QueryWrapper<>(tRoleMenu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R<TRoleMenu> selectOne(@PathVariable Serializable id) {
        return R.ok(this.tRoleMenuService.getById(id));
    }



    /**
     * 修改数据
     *
     * @param tRoleMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R<Long>  update(@RequestBody TRoleMenu tRoleMenu) {
        boolean rs = this.tRoleMenuService.updateById(tRoleMenu);
        return R.ok(tRoleMenu.getRoleId());
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
        return R.ok(this.tRoleMenuService.removeByIds(idList));
    }
}