package lyons.control;

import java.io.IOException;

/*
 * 修改密码
 * 
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Register;

public class PasswordValidation extends HttpServlet 
{
 /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public PasswordValidation()
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
			
			String username = "";
			String oldpass  = "";
			
			oldpass  = request.getParameter("oldpass").trim();
			username = request.getParameter("username").trim();

			String backNews = ""; 
			boolean userFlag = oldpass.length()>5;
			if (userFlag)
			{
				PasswordMd5 passwordmd5 =  new PasswordMd5();
				String      md5userpass =  passwordmd5.encryption(oldpass);
				
				Connection        conn  = null;
				PreparedStatement pstmt = null;
				
				conn = DbConn.getConn();
				String sql = " SELECT 1 FROM vip WHERE (SELECT userpass FROM vip WHERE username = ?)= ?";
				
				try
				{
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,md5userpass);
					
					int rs = pstmt.executeUpdate();
					System.out.println("sql已执行！");
					if (rs > 0)
					{
						request.getRequestDispatcher("/control.PasswordUpdate").forward(request, response);
					}else{
						backNews = "原密码错误"+"<br>";
						userBean.setBackNews(backNews);
						request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
					}
				} 
				catch (SQLException e)
				{
				    System.out.println(e);
					backNews = "验证密码错误"+"<br>";
					userBean.setBackNews(backNews);
					request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
				}finally
				{
					DbClose.close(pstmt, conn);
				}
			}else 
			{
				userBean.setBackNews("原密码错误，长度太短");
				request.getRequestDispatcher("/jsp/join/updatePw.jsp").forward(request, response);
			}
		}			
		
		
	

	public void init() throws ServletException
	{
		// Put your code here
	}

}
