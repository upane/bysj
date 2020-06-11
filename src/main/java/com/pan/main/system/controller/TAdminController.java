package com.pan.main.system.controller;

import com.pan.main.system.entity.TAdmin;
import com.pan.main.system.service.TAdminService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import com.sun.jndi.toolkit.url.Uri;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;
import javax.security.auth.login.CredentialNotFoundException;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * (TAdmin)控制层，建议不要修改，如果有新增的方法，在子类中写
 *
 * @author makejava
 * @since 2020-04-08 09:58:55
 */
@Api(tags = "系统——admin管理")
@RestController
@RequestMapping("/tadmin")
public class TAdminController {
  
    @Autowired
    TAdminService tAdminService;   
  
   /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tAdmin 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("显示管理员")
    @CrossOrigin
    public R<IPage<TAdmin>>  selectAll(Page<TAdmin> page, TAdmin tAdmin) {
        return R.ok (this.tAdminService.page(page, new QueryWrapper<>(tAdmin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询管理员")
    @CrossOrigin
    public R<TAdmin> selectOne(@PathVariable Serializable id) {
        return R.ok(this.tAdminService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tAdmin 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增管理员")
    @CrossOrigin
    public R<Long> insert(@RequestBody TAdmin tAdmin) {
        boolean rs = this.tAdminService.creatAdmin(tAdmin);
        
        return R.ok(rs?tAdmin.getAdminId():0);
    }

    /**
     * 修改数据
     *
     * @param tAdmin 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改管理员")
    @CrossOrigin
    public R<Long>  update(@RequestBody TAdmin tAdmin) {
        this.tAdminService.updateAdmin(tAdmin);
        return R.ok(tAdmin.getAdminId());
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除管理员")
    @CrossOrigin
    public R<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return R.ok(this.tAdminService.deleteAdmins(idList));
    }

    /**
     * 重置密码
     */
    @PostMapping(value = "/reset")
    @ApiOperation("重置密码")
    @CrossOrigin
    public R<Boolean> reset(@RequestParam("id") Long id) {
        return R.ok(this.tAdminService.resetPassword(id));
    }
    /**
     * 修改密码
     */
    @PostMapping(value = "/updatepwd")
    @ApiOperation("修改密码")
    @CrossOrigin
    public R<Boolean> updatepwd(@RequestParam("id") Long idd,@RequestParam("pwd") String pwd) {
        return R.ok(this.tAdminService.updatePassword(idd,pwd));
    }


    @GetMapping (value = "/sublogin")
    @ApiOperation("登录")
    @CrossOrigin
    public String sublogin(@RequestBody TAdmin tAdmin){
        Subject subject  = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(tAdmin.getAdname(),tAdmin.getPassword()));
        }catch (UnknownAccountException e){
            return "账户不存在";
        }catch(IncorrectCredentialsException e){
            return  "密码错误";
        }
        catch (Exception e) {
            return  "登录异常";
        }
        return "登陆成功";
    }

    @PostMapping("/reg")
    @ApiOperation("注册")
    @CrossOrigin
    public R<String> regist(@RequestParam("username") String username,@RequestParam("pwd") String pwd){
    TAdmin admin = tAdminService.findByName(username);
        if (admin != null) {
            return R.failed("该用户名已存在");
        }
        TAdmin new1 =new TAdmin();
        new1.setAdname(username);
        new1.setPassword(pwd);
        this.tAdminService.creatAdmin(new1);
        return R.ok("注册成功");
    }
    @GetMapping (value = "/logout")
    @ApiOperation("登出")
    @CrossOrigin
    public R<String> sublogout() {

        Subject subject = SecurityUtils.getSubject();
        try {
            if (subject.isAuthenticated()) {
                subject.logout();
            }
            return R.ok("退出成功");
        } catch (Exception e) {
            e.printStackTrace();
            return R.failed("未知错误");
        }

    }
}