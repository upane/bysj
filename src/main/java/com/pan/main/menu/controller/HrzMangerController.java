package com.pan.main.menu.controller;

import com.pan.main.menu.entity.HrzManger;
import com.pan.main.menu.service.HrzMangerService;

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
 * (HrzManger)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-03-30 09:27:50
 */
@Api(tags = "系统：换热站管理")
@RestController
@RequiresPermissions("hrz:*")
@RequestMapping("/api/hrzManager")
public class HrzMangerController {
  
    @Autowired
    HrzMangerService hrzMangerService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param hrzManger 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R<IPage<HrzManger>>  selectAll(Page<HrzManger> page, HrzManger hrzManger) {
        return R.ok (this.hrzMangerService.page(page, new QueryWrapper<>(hrzManger)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R<HrzManger> selectOne(@PathVariable Serializable id) {
        return R.ok(this.hrzMangerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param hrzManger 实体对象
     * @return 新增结果
     */
    @PostMapping
    @CrossOrigin
    public R<Integer> insert(@RequestBody HrzManger hrzManger) {
        boolean rs = this.hrzMangerService.save(hrzManger);
        
        return R.ok(rs?hrzManger.getId():0);
    }

    /**
     * 修改数据
     *
     * @param hrzManger 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R<Integer>  update(@RequestBody HrzManger hrzManger) {
        boolean rs = this.hrzMangerService.updateById(hrzManger);
        return R.ok(hrzManger.getId());
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
        return R.ok(this.hrzMangerService.removeByIds(idList));
    }
}