package cn.cuit.lsn.util;

import cn.cuit.lsn.pojo.Role;
import cn.cuit.lsn.pojo.User;
import cn.cuit.lsn.service.UserService;
import cn.cuit.lsn.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    // 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据

    //FIXME 1.UserRealm在xml中注册了
    // 此处不能再通过注册构造方法注册UserService
    // 2.若采用下面的方式,UserServiceImpl里面也无法用推荐的方式注入UserDao
    private UserService userService = new UserServiceImpl();

    /**
     * 提供用户信息返回权限信息,认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userEmail = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色,一个用户可以有多个角色
        Set<Role> roles = userService.findRoles(userEmail);
        Set<String> roleNames = new HashSet<String>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限
//        Set<Permission> permissions = userService.findPermissions(userName);
//        Set<String> permissionNames = new HashSet<String>();
//        for (Permission permission : permissions) {
//            permissionNames.add(permission.getPermission());
//        }
//        // 将权限名称提供给info
//        authorizationInfo.setStringPermissions(permissionNames);

        return authorizationInfo;
    }

    /**
     * 提供账户信息返回认证信息,授权
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userEmail = (String) token.getPrincipal();
        //通过用户账号查询用户信息
        User user = userService.findUserByEmail(userEmail);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
//        if (user.getLocked() == 0) {
//            // 用户被管理员锁定抛出异常
//            throw new LockedAccountException();
//        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserEmail(),
                user.getUserPasswd(), getName());
        return authenticationInfo;
    }
}
