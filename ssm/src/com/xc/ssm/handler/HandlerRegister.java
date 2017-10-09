package com.xc.ssm.handler;

import java.io.IOException;



import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xc.ssm.service.RegisterService;
import com.xc.ssm.utils.PasswordMd5;
import com.xc.ssm.entity.Register;
import com.xc.ssm.entity.Vip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class HandlerRegister {
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
	//修改用户
	@RequestMapping("/jumpupdate")
	public String JumpUpdate(){
		return "join/updatePw";
	}
	
	//修改用户信息
	@RequestMapping("/updateUser")
	public String HandleUpdate(HttpServletRequest request, HttpServletResponse response,Model model) 
			throws UnsupportedEncodingException{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Register userBean = new Register();
		request.setAttribute("userBean", userBean);
		
		String oldpass  = "";
		String username = "";
		String userpass = "";
		String phone = "";
		String address = "";
		String realname = "";
		
		oldpass  = request.getParameter("oldpass").trim();
		username = request.getParameter("username").trim();
		userpass = request.getParameter("userpass").trim();
		phone = request.getParameter("phone").trim();
		address = request.getParameter("address").trim();
		realname = request.getParameter("realname").trim();
		Vip pass = registerservice.selectByUser(username);
		PasswordMd5 passwordmd5 =  new PasswordMd5();
		String      md5userpass =  passwordmd5.encryption(oldpass);
		String regex = "[\\d]{11}";
		if((pass.getUserpass().equals(md5userpass))){
			if(phone!=null&&phone.length()>0&&!phone.matches(regex)){
				userBean.setBackNews("请正确填写11位手机号");
				return "join/updatePw";
			}else{
				Vip vip = new Vip();
				vip.setUsername(username);
				vip.setUserpass(passwordmd5.encryption(userpass));
				vip.setAddress(address);
				vip.setPhone(phone);
				vip.setRealname(realname);
				int result =  registerservice.updataVip(vip);
				System.out.println("result结果为---->"+result);
				if(result > 0){
					System.out.println("时间:"+new Date().getTime()+"修改成功");
					return "join/registerSuccess";
				}else{
					userBean.setBackNews("修改失败->sql");
					return "join/updatePw";
				}
			}
		}else{
			userBean.setBackNews("原密码错误");
			return "join/updatePw";
		}
		
		
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
					//	String backNews = ""; 
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
