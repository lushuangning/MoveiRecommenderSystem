package cn.cuit.lsn.service.impl;

import cn.cuit.lsn.dao.UserDao;
import cn.cuit.lsn.dto.UserRegisterDto;
import cn.cuit.lsn.pojo.Role;
import cn.cuit.lsn.pojo.User;
import cn.cuit.lsn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;


    @Override
    public Set<Role> findRoles(String userEmail) {


        return userDao.findRoles(userEmail);
    }

    @Override
    public User findUserByEmail(String userEmail) {

        return userDao.findUserByEmail(userEmail);
    }

    @Override
    public void register(UserRegisterDto userRegisterDto) {
        userDao.register(userRegisterDto);
        Integer userId = userDao.getUserId(userRegisterDto.getUserEmail());
        Integer roleId = userDao.getRoleId(userRegisterDto.getRoleName());
        logger.info("-----------------------------------------------------用户id为：" + userId + "，角色id为：" + roleId);
        userDao.usersRoles(userId,roleId);
    }
}
