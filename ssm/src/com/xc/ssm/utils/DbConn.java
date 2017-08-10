package com.xc.ssm.utils;
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
		
		//已加载驱动
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
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
