package cn.cuit.lsn.dto;

import org.springframework.stereotype.Component;

@Component
public class UserLoginDto {
    public UserLoginDto(){}

    private String userEmail;

    private String userPasswd;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }
}
