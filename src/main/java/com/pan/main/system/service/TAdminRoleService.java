package com.pan.main.system.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.main.system.entity.TAdminRole;

import java.util.List;

/**
 * (TAdminRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
public interface TAdminRoleService extends IService<TAdminRole> {
    /**
     * 通过角色 id 删除
     *
     * @param roleIds 角色 id
     */
    void deleteAdminRolesByRoleId(List<Long> roleIds);

    /**
     * 通过用户 id 删除
     *
     * @param admins 用户 id
     */
    void deleteAdminRolesByAdminId(List<Long> admins);

}