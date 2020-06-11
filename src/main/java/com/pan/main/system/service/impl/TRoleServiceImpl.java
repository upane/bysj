package com.pan.main.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.system.dao.TRoleDao;
import com.pan.main.system.entity.TRole;
import com.pan.main.system.entity.TRoleMenu;
import com.pan.main.system.service.TAdminRoleService;
import com.pan.main.system.service.TRoleMenuService;
import com.pan.main.system.service.TRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (TRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Service("tRoleService")
public class TRoleServiceImpl extends ServiceImpl<TRoleDao, TRole> implements TRoleService {

    @Autowired
    TRoleMenuService tRoleMenuService;
    @Autowired
    TAdminRoleService tAdminRoleService;

    @Override
    public List<TRole> findAdminRole(String name) {
        return this.baseMapper.findAdminRole(name);
    }


    @Override
    public boolean createRole(TRole role) {
        int a = this.baseMapper.insert(role);
        this.saveRoleMenus(role);
        if (a < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateRole(TRole role) {

        List<Long> roleIdList = new ArrayList<>();
        roleIdList.add(role.getRoleId());
        this.tRoleMenuService.deleteRoleMenusByRoleId(roleIdList);
        saveRoleMenus(role);

        return this.updateById(role);
    }

    @Override
    public boolean deleteRoles(Long roleId) {

        List<Long> list = Arrays.asList(roleId);
        int a = this.baseMapper.delete(new QueryWrapper<TRole>().lambda().in(TRole::getRoleId, list));

        this.tRoleMenuService.deleteRoleMenusByRoleId(list);
        this.tAdminRoleService.deleteAdminRolesByRoleId(list);
        if (a < 0) {
            return false;
        }
        return true;
    }
    private void saveRoleMenus(TRole role) {
        if (StringUtils.isNotBlank(String.valueOf(role.getMenuId()))) {
            String[] menuIds = String.valueOf(role.getMenuId()).split(StringPool.COMMA);
            List<TRoleMenu> roleMenus = new ArrayList<>();
            Arrays.stream(menuIds).forEach(menuId -> {
                TRoleMenu roleMenu = new TRoleMenu();
                roleMenu.setMenuId(Long.valueOf(menuId));
                roleMenu.setRoleId(role.getRoleId());
                roleMenus.add(roleMenu);
            });
            tRoleMenuService.saveBatch(roleMenus);
        }
    }

}