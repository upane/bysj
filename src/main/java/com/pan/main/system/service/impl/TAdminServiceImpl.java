package com.pan.main.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.system.dao.TAdminDao;
import com.pan.main.system.entity.TAdmin;
import com.pan.main.system.entity.TAdminRole;
import com.pan.main.system.service.TAdminRoleService;
import com.pan.main.system.service.TAdminService;
import com.pan.main.system.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (TAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Service("tAdminService")
public class TAdminServiceImpl extends ServiceImpl<TAdminDao, TAdmin> implements TAdminService {
    @Autowired
    TAdminRoleService tAdminRoleService;

    @Override
    public TAdmin findByName(String name) {
        QueryWrapper<TAdmin> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.lambda().eq(TAdmin::getAdname, name);
        }
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean creatAdmin(TAdmin tAdmin) {
        if(tAdmin.getRolId()==null){
            tAdmin.setRolId(TAdmin.roleid);
        }
        String pwd = Md5Util.encrypt(tAdmin.getAdminId(), tAdmin.getPassword());
        tAdmin.setPassword(pwd);
        String[] roles = String.valueOf(tAdmin.getRolId()).split(StringPool.COMMA);
        //保存用户角色，中间表
        setAdminRoles(tAdmin, roles);

        int a = this.getBaseMapper().insert(tAdmin);
        if (a < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdmin(TAdmin tAdmin) {
        String pwd = Md5Util.encrypt(tAdmin.getAdminId(), tAdmin.getPassword());
        tAdmin.setPassword(pwd);

        // 更新关联角色
        this.tAdminRoleService.remove(new LambdaQueryWrapper<TAdminRole>().eq(TAdminRole::getAdminId, tAdmin.getAdminId()));
        String[] roles = String.valueOf(tAdmin.getRolId()).split(StringPool.COMMA);
        setAdminRoles(tAdmin, roles);

        int a = this.getBaseMapper().updateById(tAdmin);
        if (a < 0) {
            return false;
        }
        return true;
    }


    @Override
    public boolean deleteAdmins(List<Long> idList) {

        // 删除关联角色
        this.tAdminRoleService.deleteAdminRolesByAdminId(idList);

        // 删除用户
       return this.removeByIds(idList);
    }

    @Override
    public boolean resetPassword(Long idd) {
            TAdmin admin = new TAdmin();
            admin.setPassword(Md5Util.encrypt(idd, TAdmin.DEFAULT_PASSWORD));
            int a = this.baseMapper.update(admin, new LambdaQueryWrapper<TAdmin>().eq(TAdmin::getAdminId, idd));
            if (a < 0) {
                return false;
            }
            return true;

    }

    @Override
    public boolean updatePassword(Long idd, String pwd) {
        TAdmin admin = new TAdmin();
        admin.setPassword(Md5Util.encrypt(idd, pwd));
        int a = this.baseMapper.update(admin, new LambdaQueryWrapper<TAdmin>().eq(TAdmin::getAdminId, idd));
        if (a < 0) {
            return false;
        }
        return true;
    }

    private void setAdminRoles(TAdmin admin, String[] roles) {
        List<TAdminRole> tAdminRoles = new ArrayList<>();
        Arrays.stream(roles).forEach(roleId -> {
            TAdminRole AdminRole = new TAdminRole();
            AdminRole.setAdminId(admin.getAdminId());
            AdminRole.setRoleId(Long.valueOf(roleId));
            tAdminRoles.add(AdminRole);
        });
        tAdminRoleService.saveBatch(tAdminRoles);
    }




}