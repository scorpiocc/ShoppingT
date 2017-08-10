package com.xc.ssm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandleJump {
	@RequestMapping("/login")
	public String HandleLogin(){
		return "join/login";
	}

}
