package com.pan.main.system.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.main.system.entity.TMenu;

import java.util.List;

/**
 * (TMenu)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
public interface TMenuService extends IService<TMenu> {
    /**
     * 查找用户权限集
     *
     * @param adname 用户名
     * @return 用户权限集合
     */
    List<TMenu> findAdminPermissions(String adname);
    /**
     * 删除menu
     *
     * @param menuId 待删除角色的 id
     */
    boolean deleteMenu(Long menuId);

}