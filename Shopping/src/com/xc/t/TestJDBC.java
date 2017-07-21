package com.xc.t;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import lyons.db.DbConn;



public class TestJDBC {
	/** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        DbConn d = new DbConn();
        d.getConn();
    	
    	
  /*      Connection conn = null;  
        Statement stmt = null;  
        String sql = null;  
        ResultSet rs = null;  
          
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","tiger");  
            stmt = conn.createStatement();  
            sql = "select * from vip";  
            rs = stmt.executeQuery(sql);  
            while(rs.next()) {  
                System.out.println("empno is : " + rs.getString(1) + " , ename is : " + rs.getString(2));  
            }  
        } catch(Exception e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(rs != null) rs.close();  
                if(stmt != null) stmt.close();  
                if(conn != null) conn.close();  
            } catch(Exception e) {  
                e.printStackTrace();  
            } 
              
        }   */
  
    }  
  
}
