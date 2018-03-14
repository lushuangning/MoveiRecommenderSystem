package cn.cuit.lsn.controller;

import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.dto.UserRegisterDto;
import cn.cuit.lsn.pojo.User;
import cn.cuit.lsn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loginRegister")
public class LoginRegisterController {

    private static Logger logger = LoggerFactory.getLogger(LoginRegisterController.class);

    //Spring推荐的注入方式
    private final UserService userService;

    @Autowired
    public LoginRegisterController(UserService userService){
        this.userService = userService;
    }


    @RequestMapping("/login")
    public @ResponseBody  String userLogin(@RequestBody UserLoginDto userLoginDto){
        logger.info("-------------------------------------------User information:" + userLoginDto.getUserEmail() + userLoginDto.getUserPasswd());
        UsernamePasswordToken token = new UsernamePasswordToken(userLoginDto.getUserEmail(),userLoginDto.getUserPasswd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            //捕获密码异常

        }catch (UnknownAccountException uae){
            //捕获未知用户名异常
        }catch (ExcessiveAttemptsException eae){
            //捕获错误登录过多的异常
        }

        //        UserInfoDto userInfoDto = loginRegisterService.loginCheck(userLogin);
//        if (userInfoDto != null){
//            return JSON.toJSONString(userInfoDto);
//        }else {
//            return "";
//        }
        User user = userService.findUserByEmail(userLoginDto.getUserEmail());
        subject.getSession().setAttribute("user",user);

        return  "";
    }

    @RequestMapping("/register")
    public @ResponseBody String userRegister(@RequestBody UserRegisterDto userRegisterDto){
        //MD5加密两次
        String hashPasswd = new SimpleHash("md5",userRegisterDto.getUserPasswd(),2).toString();
        userRegisterDto.setUserPasswd(hashPasswd);
        userService.register(userRegisterDto);
        return null;
    }
}
