package com.xc.ssm.handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xc.ssm.service.RegisterService;
import com.xc.ssm.utils.PasswordMd5;
import com.xc.ssm.utils.DbClose;
import com.xc.ssm.utils.DbConn;
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
	@RequestMapping("/index")
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
	public String Handlesubmit(HttpServletRequest request, HttpServletResponse response,Model model)
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
						//request.getRequestDispatcher("../jsp/join/register.jsp").forward(request, response);
						
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
							
							/*Connection        conn  = null;
							PreparedStatement pstmt = null;
							
							conn = DbConn.getConn();
							String sql = "INSERT INTO vip(username,userpass,phone,address,realname) VALUES(?,?,?,?,?)";
							
							try
							{	*/
								
								
								int result = registerservice.insertVip(register);
								System.out.println("--------------"+result+"--------------");
								return "join/registerSuccess";
								
								/*pstmt = conn.prepareStatement(sql);
								pstmt.setString(1,username);
								pstmt.setString(2,md5userpass); 
								pstmt.setString(3,phone);
								pstmt.setString(4,address);
								pstmt.setString(5,realname);
								
								int rs = pstmt.executeUpdate();
								if (rs > 0)
								{
									backNews = "注册成功";
									userBean.setBackNews(backNews);
									return "join/registerSuccess";
									//request.getRequestDispatcher("join/registerSuccess.jsp").forward(request, response);
								}
							} catch (SQLIntegrityConstraintViolationException e)
							{
							    System.out.println("异常="+e);
								backNews = "用户名不能为空"+"<br>";
								userBean.setBackNews(backNews);
								return "join/updatePw";
								//request.getRequestDispatcher("join/updatePw.jsp").forward(request, response);
							}
							catch (SQLException e)
							{
							    System.out.println("异常="+e);
								backNews = "该用户名已被注册"+"<br>";
								userBean.setBackNews(backNews);
								return "join/register";
								//request.getRequestDispatcher("join/register.jsp").forward(request, response);
							}finally
							{
								//DbClose.close(pstmt, conn);
							}*/
						}else 
						{
							userBean.setBackNews("密码不合法");
							return "join/register";
							//request.getRequestDispatcher("join/register.jsp").forward(request, response);
						}
					}
		
	}
}
