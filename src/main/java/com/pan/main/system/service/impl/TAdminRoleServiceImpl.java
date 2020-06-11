package com.pan.main.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.system.dao.TAdminRoleDao;
import com.pan.main.system.entity.TAdminRole;
import com.pan.main.system.service.TAdminRoleService;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * (TAdminRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Service("tAdminRoleService")
public class TAdminRoleServiceImpl extends ServiceImpl<TAdminRoleDao, TAdminRole> implements TAdminRoleService {
    @Override
    public void deleteAdminRolesByRoleId(List<Long> roleIds) {
        this.baseMapper.delete(new QueryWrapper<TAdminRole>().lambda().in(TAdminRole::getRoleId,roleIds));
    }

    @Override
    public void deleteAdminRolesByAdminId(List<Long> admins) {
        this.baseMapper.delete(new QueryWrapper<TAdminRole>().lambda().in(TAdminRole::getAdminId,admins));
    }
}