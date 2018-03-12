package cn.cuit.lsn.service;

import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.dto.UserRegisterDto;
import org.springframework.stereotype.Service;


public interface LoginRegisterService {
    UserInfoDto loginCheck(UserLoginDto userLogin);

    void userRegister(UserRegisterDto userRegisterDto);
}
