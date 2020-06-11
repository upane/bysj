package com.pan.main.system.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.main.system.entity.TRoleMenu;

import java.util.List;

/**
 * (TRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 09:49:54
 */
public interface TRoleMenuService extends IService<TRoleMenu> {

    /**
     * 通过角色 id 删除
     *
     * @param roleIds 角色 id
     */
    void deleteRoleMenusByRoleId(List<Long> roleIds);

    /**
     * 通过菜单（按钮）id 删除
     *
     * @param menuIds 菜单（按钮）id
     */
    void deleteRoleMenusByMenuId(List<Long> menuIds);

}