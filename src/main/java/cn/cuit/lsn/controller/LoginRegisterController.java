package cn.cuit.lsn.controller;

import cn.cuit.lsn.dto.UserInfoDto;
import cn.cuit.lsn.dto.UserLoginDto;
import cn.cuit.lsn.service.LoginRegisterService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loginRegister")
public class LoginRegisterController {
    @Autowired
    LoginRegisterService loginRegisterService;

    @RequestMapping("/userLogin")
    public @ResponseBody  String userLogin(@RequestBody UserLoginDto userLogin){
        UserInfoDto userInfoDto = loginRegisterService.loginCheck(userLogin);
        return JSON.toJSONString(userInfoDto);
    }
}
