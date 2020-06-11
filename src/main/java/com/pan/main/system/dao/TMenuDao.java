package com.pan.main.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.main.system.entity.TMenu;

import java.util.List;

/**
 * (TMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
public interface TMenuDao extends BaseMapper<TMenu> {
    /**
     * 查找用户权限集
     *
     * @param adname 用户名
     * @return 用户权限集合
     */
    List<TMenu> findAdminPermissions(String adname);

}