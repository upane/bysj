package com.pan.main.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.system.dao.TMenuDao;
import com.pan.main.system.entity.TMenu;
import com.pan.main.system.service.TMenuService;
import com.pan.main.system.service.TRoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (TMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
@Service("tMenuService")
public class TMenuServiceImpl extends ServiceImpl<TMenuDao, TMenu> implements TMenuService {
    @Autowired
    TRoleMenuService tRoleMenuService;

    @Override
    public List<TMenu> findAdminPermissions(String adname) {
        return this.baseMapper.findAdminPermissions(adname);
    }

    @Override
    public boolean deleteMenu(Long menuId) {

        int a =this.baseMapper.deleteById(menuId);

        List<Long> list = Arrays.asList(menuId);
        tRoleMenuService.deleteRoleMenusByMenuId(list);
        if (a < 0) {
            return false;
        }
        return true;

    }

}