package com.xc.ssm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class HandlerSearch {
	//跳转至搜索界面
	@RequestMapping("/ByKey")
	public String SearchByKeyWord(){
		return "browse/searchByKeyWord";
	}

}
