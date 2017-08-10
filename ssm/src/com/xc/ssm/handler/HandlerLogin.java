package com.xc.ssm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class HandlerLogin {
	@RequestMapping("/index")
	public String Handlerlogin(){
		return "join/login";
	}
	

}
