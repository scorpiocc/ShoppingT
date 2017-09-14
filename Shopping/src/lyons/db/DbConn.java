package lyons.db;
/**
 * 链接数据库
 * @author Lyons
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.apache.log4j.Logger;

public class DbConn
{
	private static Logger logger= Logger.getLogger(DbConn.class);
	public static Connection getConn()
	{
		Connection conn = null;
		
		String user 	= "scott";
		String passwd	= "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		 // String user   = "scorpio";
		  //String passwd	= "111111";
		  //String url    = "jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=utf8";
		//已加载驱动
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url,user,passwd);
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
				logger.error("找不到driver类");
			} catch (SQLException e)
			{
				e.printStackTrace();
				logger.error("sql执行失败");
			}
			
		return conn;
	}
	
}
