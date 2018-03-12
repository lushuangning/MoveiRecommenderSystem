package cn.cuit.lsn.service;

import cn.cuit.lsn.pojo.Role;
import cn.cuit.lsn.pojo.User;

import java.util.Set;

public interface UserService {
    Set<Role> findRoles(String userName);

    User findByUserEmail(String userName);
}
