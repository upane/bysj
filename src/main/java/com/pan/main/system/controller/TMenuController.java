package com.pan.main.system.controller;

import com.pan.main.system.entity.TMenu;
import com.pan.main.system.service.TMenuService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import com.pan.main.system.service.TRoleMenuService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (TMenu)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Api(tags = "系统——权限菜单")
@RestController
@RequiresPermissions("menu:*")
@RequestMapping("/menu")
public class TMenuController {
  
    @Autowired
    TMenuService tMenuService;
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tMenu 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R<IPage<TMenu>>  selectAll(Page<TMenu> page, TMenu tMenu) {
        return R.ok (this.tMenuService.page(page, new QueryWrapper<>(tMenu)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R<TMenu> selectOne(@PathVariable Serializable id) {
        return R.ok(this.tMenuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tMenu 实体对象
     * @return 新增结果
     */
    @PostMapping
    @CrossOrigin
    public R<Long> insert(@RequestBody TMenu tMenu) {
        boolean rs = this.tMenuService.save(tMenu);
        
        return R.ok(rs?tMenu.getMenuId():0);
    }

    /**
     * 修改数据
     *
     * @param tMenu 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R<Long>  update(@RequestBody TMenu tMenu) {
        boolean rs = this.tMenuService.updateById(tMenu);
        return R.ok(tMenu.getMenuId());
    }

    /**
     * 删除数据
     *
     * @param menuId 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @CrossOrigin
    public R<Boolean> delete(@RequestParam("idList") Long menuId) {
        return R.ok(this.tMenuService.deleteMenu(menuId));
    }


}