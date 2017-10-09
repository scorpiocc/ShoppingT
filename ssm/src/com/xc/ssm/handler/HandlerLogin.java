package com.xc.ssm.handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.ssm.entity.Vip;
import com.xc.ssm.service.LoginUserService;
import com.xc.ssm.utils.LoginHandling;

@Controller
@RequestMapping("/login")
public class HandlerLogin {
	@Resource
	private LoginUserService loginuserservice;
	
	//登陆界面
	@RequestMapping("/login")
	public String Handlerlogin(){
		return "join/login";
	}
	//首页
	@RequestMapping("/index")
	public String HandlerIndex(){
		return "../../index";
	}
	//退出
	@RequestMapping("/exit")
	public String UserExit(HttpServletRequest request, Model model){
		HttpSession session = request.getSession(true);//true一定要写。否则，获取不到当前session时会自动创建一个
		session.invalidate();
		return "../../index";
	}

	//登陆提交
	@RequestMapping("/submit")
	public String HandlerLSubmit(HttpServletRequest request, HttpServletResponse response,Model model){
		response.setContentType("text/html;charset=UTF-8");
		//创建登陆处理对象
		LoginHandling loginhanding = new LoginHandling();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("编码问题--"+e);
			e.printStackTrace();
		}//servlet中也要此项，否则取值乱码
		String username = "";
		String userpass = "";
		String cookies  = "";
		Vip result      = null;
		username = request.getParameter("username");
		userpass = request.getParameter("userpass");
		cookies = request.getParameter("isCookie");
		System.out.println("name="+username+"  pass="+userpass+"  cookies="+cookies);
		try {
			loginhanding.handleCookies(request,response,username,userpass,cookies); //处理用户cookies信息
			System.out.println("处理用户cookies信息成功");
		} catch (ServletException e) {
			e.printStackTrace();
			System.out.println("-----ServletException出错了！！"+e);
		} catch (IOException e) {
			e.printStackTrace();	
			System.out.println("-----IOException出错了！！"+e);
		}//处理cookies信息
		System.out.println("开始匹配");
		 result = loginuserservice.LoginUser(username, userpass);
		System.out.println("查找用户成功");
		
		if(result != null){
			loginhanding.success(request,response,username); //登陆成功，储存用户信息
			System.out.println("储存用户信息成功");
			return "join/landing";
		}else 
		{
			String backNews = "用户名或者密码错误";
			System.out.println(backNews);
			model.addAttribute("backnews", backNews);
			return "join/login";
		}
	}

}
