package cn.cuit.lsn.service.impl;

import cn.cuit.lsn.dao.UserDao;
import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.dto.UserRegisterDto;
import cn.cuit.lsn.service.LoginRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService {

    private static Logger logger = LoggerFactory.getLogger(LoginRegisterServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Override
    public UserInfoDto loginCheck(UserLoginDto userLogin) {
        Integer userId = userDao.loginCheck(userLogin);
        logger.info("-------------------------------------------- The userId is:" + userId);

        if (userId == null){
            return null;
        }else {
            UserInfoDto userInfoDto = userDao.userInfo(userId);
            logger.info("-------------------------------------------- 用户id：" + userInfoDto.getUserId() + "，用户名："
                    + userInfoDto.getUserName() + "，email：" + userInfoDto.getUserEmail() + "，角色名：" + userInfoDto.getRoleName());
            return userInfoDto;
        }
    }

    @Override
    public void userRegister(UserRegisterDto userRegisterDto) {
        userDao.userRegister(userRegisterDto);
        Integer userId = userDao.getUserId(userRegisterDto.getUserEmail());
        Integer roleId = userDao.getRoleId(userRegisterDto.getRoleName());
        logger.info("-----------------------------------------------------用户id为：" + userId + "，角色id为：" + roleId);
        userDao.usersRoles(userId,roleId);
    }
}
