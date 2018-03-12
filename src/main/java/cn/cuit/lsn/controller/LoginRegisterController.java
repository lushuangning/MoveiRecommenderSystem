package cn.cuit.lsn.controller;

import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.dto.UserRegisterDto;
import cn.cuit.lsn.service.LoginRegisterService;
import cn.cuit.lsn.service.impl.LoginRegisterServiceImpl;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
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

    @Autowired
    LoginRegisterService loginRegisterService;

    @RequestMapping("/userLogin")

    public @ResponseBody  String userLogin(@RequestBody UserLoginDto userLogin){
        logger.info("-------------------------------------------User information:" + userLogin.getUserEmail() + userLogin.getUserPasswd());
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUserEmail(),userLogin.getUserPasswd());
        SecurityUtils.getSubject().login(token);
        //        UserInfoDto userInfoDto = loginRegisterService.loginCheck(userLogin);
//        if (userInfoDto != null){
//            return JSON.toJSONString(userInfoDto);
//        }else {
//            return "";
//        }

        return  "";
    }

    @RequestMapping("/userRegister")
    public @ResponseBody String userRegister(@RequestBody UserRegisterDto userRegisterDto){
        String hashPasswd = new SimpleHash("md5",userRegisterDto.getUserPasswd(),2).toString();
        userRegisterDto.setUserPasswd(hashPasswd);
        loginRegisterService.userRegister(userRegisterDto);
        return null;
    }
}
