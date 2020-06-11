package com.pan.main.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.main.system.entity.TRole;

import java.util.List;

/**
 * (TRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
public interface TRoleDao extends BaseMapper<TRole> {

    /**
     * 通过用户名查找用户角色
     *
     * @param name 用户名
     * @return 用户角色集合
     */
    List<TRole> findAdminRole(String name);

}