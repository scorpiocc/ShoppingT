package lyons.control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
@WebServlet("/Log4JTestServlet") 
public class Log4JTestServlet extends HttpServlet 
{
 /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(Log4JTestServlet.class); 
	/**
	 * Constructor of the object.
	 */
	public Log4JTestServlet()
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

		// 记录debug级别的信息 
		 logger.debug("This is debug message1."); 
		 // 记录info级别的信息 
		 logger.info("This is info message2."); 
		 // 记录error级别的信息 
		 logger.error("This is error message3."); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		 doGet(request,response); 
		
	}

	public void init(ServletConfig config) throws ServletException
	{
		
	}

}
