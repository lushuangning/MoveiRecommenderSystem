package cn.cuit.lsn.dao;

import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.dto.UserRegisterDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    /**
     *
     * @param userLoginDto 用户登录信息
     * @return 用户id，登录失败返回null
     */
    Integer loginCheck(UserLoginDto userLoginDto);

    Integer getUserId(@Param("userEmail")String userEmail);

    Integer getRoleId(@Param("roleName")String roleName);

    UserInfoDto userInfo(@Param("userId")Integer userId);

    void userRegister(UserRegisterDto userRegisterDto);

    void usersRoles(@Param("userId")Integer userId, @Param("roleId")Integer roleId);
}
