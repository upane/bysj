package com.pan.main.system.configuration;


import com.pan.main.system.entity.TAdmin;
import com.pan.main.system.entity.TMenu;
import com.pan.main.system.entity.TRole;
import com.pan.main.system.service.TAdminService;
import com.pan.main.system.service.TMenuService;
import com.pan.main.system.service.TRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ShiroRealm extends AuthorizingRealm {

    /**
     *管理员用户
     */
    @Autowired
    TAdminService tAdminService;

    /**
     * 菜单访问
     */
    @Autowired
    TMenuService tMenuService;
    /**
     * 角色
     */
    @Autowired
    TRoleService tRoleService;


    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        TAdmin tAdmin = (TAdmin) SecurityUtils.getSubject().getPrincipal();
        String name = tAdmin.getAdname();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取用户角色集
        List<TRole> roleList = this.tRoleService.findAdminRole(name);
        Set<String> roleSet = roleList.stream().map(TRole::getName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<TMenu> permissionList = this.tMenuService.findAdminPermissions(name);
        Set<String> permissionSet = permissionList.stream().map(TMenu::getPerms).collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permissionSet);

        return simpleAuthorizationInfo;
    }
    /**
     * 身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户输入的用户名
        String username = (String) token.getPrincipal();

        // 通过用户名到数据库查询用户信息
        TAdmin user = this.tAdminService.findByName(username);

        //加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setStoredCredentialsHexEncoded(true);
        setCredentialsMatcher(matcher);


        String password_db = user.getPassword();
        String salt = String.valueOf(user.getAdminId());

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, password_db,ByteSource.Util.bytes(salt),getName());

        return authenticationInfo;

    }





}
