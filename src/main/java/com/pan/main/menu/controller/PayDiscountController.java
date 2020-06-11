package com.pan.main.menu.controller;

import com.pan.main.menu.entity.PayDiscount;
import com.pan.main.menu.service.PayDiscountService;

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
 * (PayDiscount)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-03-30 10:48:03
 */
@Api(tags = "系统：缴费管理--优惠")
@RestController
@RequiresPermissions("disc:*")
@RequestMapping("/api/payDiscount")
public class PayDiscountController {
  
    @Autowired
    PayDiscountService payDiscountService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param payDiscount 查询实体
     * @return 所有数据
     */
    @GetMapping
    @CrossOrigin
    public R<IPage<PayDiscount>>  selectAll(Page<PayDiscount> page, PayDiscount payDiscount) {
        return R.ok (this.payDiscountService.page(page, new QueryWrapper<>(payDiscount)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @CrossOrigin
    public R<PayDiscount> selectOne(@PathVariable Serializable id) {
        return R.ok(this.payDiscountService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param payDiscount 实体对象
     * @return 新增结果
     */
    @PostMapping
    @CrossOrigin
    public R<Integer> insert(@RequestBody PayDiscount payDiscount) {
        boolean rs = this.payDiscountService.save(payDiscount);
        
        return R.ok(rs?payDiscount.getDiscountid():0);
    }

    /**
     * 修改数据
     *
     * @param payDiscount 实体对象
     * @return 修改结果
     */
    @PutMapping
    @CrossOrigin
    public R<Integer>  update(@RequestBody PayDiscount payDiscount) {
        boolean rs = this.payDiscountService.updateById(payDiscount);
        return R.ok(payDiscount.getDiscountid());
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
        return R.ok(this.payDiscountService.removeByIds(idList));
    }
}