package cn.cuit.lsn.service;

import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginRegisterService {
    UserInfoDto loginCheck(UserLoginDto userLogin);
}
