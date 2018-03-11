package cn.cuit.lsn.service.impl;

import cn.cuit.lsn.dao.UserDao;
import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginRegisterServiceImpl implements LoginRegisterService {

    @Autowired
    UserDao userDao;

    @Override
    public UserInfoDto loginCheck(UserLoginDto userLogin) {
        Integer userId = userDao.loginCheck(userLogin);
        if (userId == null){
            return null;
        }else {
            return userDao.userInfo(userId);
        }

    }
}
