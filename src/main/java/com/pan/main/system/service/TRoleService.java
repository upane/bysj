package com.pan.main.system.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.main.system.entity.TRole;

import java.util.List;

/**
 * (TRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
public interface TRoleService extends IService<TRole> {


    /**
     * 通过用户名查找用户角色
     *
     * @param name 用户名
     * @return 用户角色集合
     */
    List<TRole> findAdminRole(String name);


    /**
     * 新增角色
     *
     * @param role 待新增的角色
     */
    boolean createRole(TRole role);

    /**
     * 修改角色
     *
     * @param role 待修改的角色
     */
    boolean updateRole(TRole role);


    /**
     * 删除角色
     *
     * @param roleId 待删除角色的 id
     */
    boolean deleteRoles(Long roleId);


}