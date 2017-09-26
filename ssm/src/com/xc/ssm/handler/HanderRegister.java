package com.xc.ssm.handler;

import java.io.IOException;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xc.ssm.service.RegisterService;
import com.xc.ssm.utils.PasswordMd5;
import com.xc.ssm.entity.Register;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class HanderRegister {
	@Resource
	private RegisterService registerservice;
	
	//进去注册界面
	@RequestMapping("/register")
	public String Handlerregister(){
		return "join/register";
	}
	//进去成功跳转登陆界面
		@RequestMapping("/jumplogin")
		public String JumpLogin(){
			return "join/login";
		}
	
	//注册表单提交
	@RequestMapping("/submit")
	public String HandleRSubmit(HttpServletRequest request, HttpServletResponse response,Model model)
			throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Register userBean = new Register();
		request.setAttribute("userBean", userBean);
		
		String username = "";
		String userpass = "";
		String again_userpass = "";
		String phone = "";
		String address = "";
		String realname = "";
		
		username = request.getParameter("username").trim();
		userpass = request.getParameter("userpass").trim();
		again_userpass = request.getParameter("again_userpass").trim();
		phone = request.getParameter("phone").trim();
		address = request.getParameter("address").trim();
		realname = request.getParameter("realname").trim();
		
		if (username==null)
		{
			username = "";
		}
		if (userpass==""|userpass==null)
		{
			userpass = "error";
		}

		String regex = "[\\d]{11}";
		if (!(again_userpass.equals(userpass)))
		{
			userBean.setBackNews("两次密码不一致,注册失败");
			return "join/register";
		}else if (phone!=null&&phone.length()>0&&!phone.matches(regex)) 
				{
						userBean.setBackNews("请正确填写11位手机号");
						return "join/register";
						
				}else 
					{
						String backNews = ""; 
						boolean userFlag = userpass.length()>5;
						if (userFlag)
						{
							PasswordMd5 passwordmd5 =  new PasswordMd5();
							String      md5userpass =  passwordmd5.encryption(userpass);
							
							Register register = new Register();
							register.setUsername(username);
							register.setUserpass(md5userpass);
							register.setPhone(phone);
							register.setAddress(address);
							register.setRealname(realname);
								
								int result = registerservice.insertVip(register);
								System.out.println("--------------"+result+"--------------");
								return "join/registerSuccess";
											
						}else 
						{
							userBean.setBackNews("密码不合法");
							return "join/register";
						}
					}
		
	}
}
