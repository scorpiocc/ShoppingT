package lyons.control;

import java.io.IOException;
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


/**
 * 注册处理
 * @author Lyons(zhanglei)
 *
 */

public class HandleRegister extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public HandleRegister()
	{
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

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
			request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
		}else if (phone!=null&&phone.length()>0&&!phone.matches(regex)) 
				{
						userBean.setBackNews("请正确填写11位手机号");
						request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
						return;
				}else 
					{
						String backNews = ""; 
			//			String regex2 = "[\\w]{6,16}";
			//			boolean userFlag = username.matches(regex2) && userpass.length()>5;
						boolean userFlag = userpass.length()>5;
						if (userFlag)
						{
							PasswordMd5 passwordmd5 =  new PasswordMd5();
							String      md5userpass =  passwordmd5.encryption(userpass);
							
							Connection        conn  = null;
							PreparedStatement pstmt = null;
							
							conn = DbConn.getConn();
							String sql = "INSERT INTO vip(username,userpass,phone,address,realname) VALUES(?,?,?,?,?)";
							
							try
							{
								
								pstmt = conn.prepareStatement(sql);
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
									request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
								}
							} catch (SQLIntegrityConstraintViolationException e)
							{
							    System.out.println(e);
								backNews = "用户名不能为空"+"<br>";
								userBean.setBackNews(backNews);
								request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
							}
							catch (SQLException e)
							{
							    System.out.println(e);
								backNews = "该用户名已被注册"+"<br>";
								userBean.setBackNews(backNews);
								request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
							}finally
							{
								DbClose.close(pstmt, conn);
							}
						}else 
						{
							userBean.setBackNews("密码不合法");
							request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
						}
					}
	}

	public void init() throws ServletException
	{
	}

}
