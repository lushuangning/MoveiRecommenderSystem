package cn.cuit.lsn.service.impl;

import cn.cuit.lsn.pojo.Role;
import cn.cuit.lsn.pojo.User;
import cn.cuit.lsn.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Set<Role> findRoles(String userName) {
        return null;
    }

    @Override
    public User findByUserEmail(String userEmail) {
        return null;
    }
}
