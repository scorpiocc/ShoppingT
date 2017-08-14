package lyons.user.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyons.user.service.UserService;
import lyons.util.PasswordMd5;

/**
 * µ«¬Ω¥¶¿Ì
 * @author Lyons(zhanglei)
 *
 */

@SuppressWarnings("serial")
public class LoginAction extends HttpServlet 
{
    Map<String, String> userMap;
    UserService userService;
    
    @Override
    public void init() throws ServletException
    {
        userMap = new HashMap<String, String>();
        userService = new UserService();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
        request.setCharacterEncoding("UTF-8");
        PasswordMd5 md5  = new PasswordMd5();  //º”√‹
		String userpass =  md5.encryption(request.getParameter("userpass"));
		userMap.put("userpass", userpass);
		userMap.put("username", request.getParameter("username"));
		userMap.put("isCookie", request.getParameter("isCookie"));
		
		userService.userLogin(request,response,userMap);
	}

}