package com.pan.main.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pan.main.system.dao.TRoleMenuDao;
import com.pan.main.system.entity.TRoleMenu;
import com.pan.main.system.service.TRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (TRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 09:49:54
 */
@Service("tRoleMenuService")
public class TRoleMenuServiceImpl extends ServiceImpl<TRoleMenuDao, TRoleMenu> implements TRoleMenuService {
    @Override
    public void deleteRoleMenusByRoleId(List<Long> roleIds) {
            this.baseMapper.delete(new QueryWrapper<TRoleMenu>().lambda().in(TRoleMenu::getRoleId, roleIds));
    }

    @Override
    public void deleteRoleMenusByMenuId(List<Long> menuIds) {
            this.baseMapper.delete(new QueryWrapper<TRoleMenu>().lambda().in(TRoleMenu::getMenuId, menuIds));
    }


}