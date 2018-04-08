package cn.cuit.lsn.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserRole {

    private User user;

    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
