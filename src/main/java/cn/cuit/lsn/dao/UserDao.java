package cn.cuit.lsn.dao;

import cn.cuit.lsn.dto.UserRegisterDto;
import cn.cuit.lsn.pojo.Role;
import cn.cuit.lsn.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserDao {

    /**
     * 根据用户账号查询用户id
     * @param userEmail 用户账号
     * @return 用户id
     */
    Integer getUserId(String userEmail);

    /**
     * 根据角色名称查询角色id
     * @param roleName
     * @return
     */
    Integer getRoleId(String roleName);
//
//    /**
//     * 根据用户id查询用户信息
//     * @param userId 用户id
//     * @return 用户信息
//     */
//    UserInfoDto userInfo(Integer userId);

    /**
     * 用户注册
     * @param userRegisterDto 用户注册信息
     */
    void register(UserRegisterDto userRegisterDto);

    /**
     * 查询用户角色名
     * @param userId 用户id
     * @param roleId 角色id
     */
    void usersRoles(Integer userId, Integer roleId);

    /**
     * 根据用户账号查询用户的角色名称
     * @param userEmail 用户名称
     * @return 角色集合Set<Role>,一个用户可能有多种角色
     */
    Set<Role> findRoles(String userEmail);

    /**
     * 根据用户账号查询用户信息
     * @param userEmail 用户账号
     * @return 用户id
     */
    User findUserByEmail(String userEmail);
}
