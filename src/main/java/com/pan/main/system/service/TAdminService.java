package com.pan.main.system.service;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pan.main.system.entity.TAdmin;
import com.pan.main.system.utils.Md5Util;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.List;

/**
 * (TAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 09:49:53
 */
public interface TAdminService extends IService<TAdmin> {
    TAdmin findByName(String name);


    /**
     * 增加
     */
    boolean creatAdmin(TAdmin tAdmin);

    /**
     * 删除用户
     */
    boolean deleteAdmins(List<Long> idList);

    /**
     * 修改用户
     */
    boolean updateAdmin(TAdmin tAdmin);


    /**
     * 重置密码
     */
    boolean resetPassword(Long idd);

    /**
     * 修改密码
     */
    boolean updatePassword(Long idd, String pwd);



}