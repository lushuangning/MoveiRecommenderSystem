package cn.cuit.lsn.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {
	@Autowired
    //注入Service

	private static final Logger logger = Logger.getLogger(PageController.class);
	
	@RequestMapping("/index")
	public String index(){
		
		return "index";
	}

    @RequestMapping("/upload")
    public String upload(){

        return "upload";
    }

	@RequestMapping("/register")
	public String register(){

		return "register";
	}
}
