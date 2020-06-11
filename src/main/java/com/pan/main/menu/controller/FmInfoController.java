package com.pan.main.menu.controller;

import com.pan.main.menu.entity.FmInfo;
import com.pan.main.menu.service.FmInfoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (FmInfo)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-03-30 09:17:58
 */
@Api(tags = "系统：阀门管理")
@RestController
@RequiresPermissions("fm:*")
@RequestMapping("/api/fmInfo")
public class FmInfoController {
  
    @Autowired
    FmInfoService fmInfoService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param fmInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("显示阀门信息")
    @CrossOrigin
    public R<IPage<FmInfo>>  selectAll(Page<FmInfo> page, FmInfo fmInfo) {
        return R.ok (this.fmInfoService.page(page, new QueryWrapper<>(fmInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询阀门信息")
    @CrossOrigin
    public R<FmInfo> selectOne(@PathVariable Serializable id) {
        return R.ok(this.fmInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param fmInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("增加阀门")
    @CrossOrigin
    public R<Integer> insert(@RequestBody FmInfo fmInfo) {
        boolean rs = this.fmInfoService.save(fmInfo);
        
        return R.ok(rs?fmInfo.getId():0);
    }

    /**
     * 修改数据
     *
     * @param fmInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改阀门信息")
    @CrossOrigin
    public R<Integer>  update(@RequestBody FmInfo fmInfo) {
        boolean rs = this.fmInfoService.updateById(fmInfo);
        return R.ok(fmInfo.getId());
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除阀门")
    @CrossOrigin
    public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.fmInfoService.removeByIds(idList));
    }
}