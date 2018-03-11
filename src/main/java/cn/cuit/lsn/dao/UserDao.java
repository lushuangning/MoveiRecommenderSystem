package cn.cuit.lsn.dao;

import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;

public interface UserDao {
    Integer loginCheck(UserLoginDto userLoginDto);

    UserInfoDto userInfo(Integer userId);
}
