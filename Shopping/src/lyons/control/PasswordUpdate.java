package lyons.control;

import java.io.IOException;

/*
 * 修改密码
 * 
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Register;

public class PasswordUpdate extends HttpServlet 
{
 /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public PasswordUpdate()
	{
		super();
	}

	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			Register userBean = new Register();
			request.setAttribute("userBean", userBean);
			
			String oldpass  = "";
			String username = "";
			String userpass = "";
			String again_userpass = "";
			String phone = "";
			String address = "";
			String realname = "";
			
			oldpass  = request.getParameter("oldpass").trim();
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
				request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
			}else if (phone!=null&&phone.length()>0&&!phone.matches(regex)) 
					{
							userBean.setBackNews("请正确填写11位手机号");
							request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
							return;
					}else 
						{
							String backNews = ""; 
							boolean userFlag = userpass.length()>5;
							if (userFlag)
							{
							
								PasswordMd5 passwordmd5 =  new PasswordMd5();
								String      md5userpass =  passwordmd5.encryption(userpass);
								
								Connection        conn  = null;
								PreparedStatement pstmt = null;
								
								conn = DbConn.getConn();
								try
								{
								String sql   = "UPDATE vip SET userpass = ?";
								if(phone != null && !"".equals(phone)){
									sql += ",phone = ?";
								}
								if(address != null && !"".equals(address)){
									sql += ",address = ?";
								}
								if(realname != null && !"".equals(realname)){
									sql += ",realname = ?";
								}
								
								    sql  += " WHERE username  = ?";
								
								System.out.println("sql语句为"+sql);
									pstmt = conn.prepareStatement(sql);
									pstmt.setString(1,md5userpass); 
									int Inum = 1;
									if(phone != null && !"".equals(phone)){
										Inum++;
										pstmt.setString(Inum,phone);
										System.out.println("-----phone已经添加为："+phone);
									}
									if(address != null && !"".equals(address)){
										Inum++;
										pstmt.setString(Inum,address);
										System.out.println("-----address已经添加为："+address);
									}
									if(realname != null && !"".equals(realname)){
										Inum++;
										pstmt.setString(Inum,realname);
										System.out.println("-----realname已经添加为："+realname);
									}
									Inum++;
									pstmt.setString(Inum,username);
									
									int rs = pstmt.executeUpdate();
									if (rs > 0)
									{
										backNews = "修改成功";
										userBean.setBackNews(backNews);
										request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
									}
								} 
								catch (SQLException e)
								{
								    System.out.println(e);
									backNews = "修改失败,请重试！"+"<br>";
									userBean.setBackNews(backNews);
									request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
								}finally
								{
									DbClose.close(pstmt, conn);
								}
							}else 
							{
								userBean.setBackNews("新密码长度不够");
								request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
							}
							
						}
		
		
	}

	public void init() throws ServletException
	{
		// Put your code here
	}

}
