package com.xc.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class TuLingApi {

	public String turing(String info, String loc, String userid, String appkey) {
		String url = "https://way.jd.com/turing/turing";
		String param = "";
		String result = "";
		if(info!=""){
			param += ("info="+info+"&");
		}
		if(loc!=""){
			param += ("loc="+loc+"&");
		}
		if(userid!=""){
			param += ("userid="+userid+"&");
		}
		param += ("appkey="+appkey);
		System.out.println("Scorpio_cc:"+info);
		BufferedReader read=null;//读取访问结果
		    
		   try {
		    //创建url
		    URL realurl=new URL(url+"?"+param);
		    //打开连接
		    URLConnection connection=realurl.openConnection();
		     // 设置通用的请求属性
		             connection.setRequestProperty("accept", "*/*");
		             connection.setRequestProperty("connection", "Keep-Alive");
		             connection.setRequestProperty("user-agent",
		                     "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		             //建立连接
		             connection.connect();
		             /*  
		          // 获取所有响应头字段
		             Map<String, List<String>> map = connection.getHeaderFields();
		              //遍历所有的响应头字段，获取到cookies等
		             for (String key : map.keySet()) {
		                 System.out.println(key + "--->" + map.get(key));
		             }*/
		             
		             // 定义 BufferedReader输入流来读取URL的响应
		             read = new BufferedReader(new InputStreamReader(
		                     connection.getInputStream(),"UTF-8"));
		             String line;//循环读取
		             while ((line = read.readLine()) != null) {
		                 result += line;
		             }
		   } catch (IOException e) {
		    e.printStackTrace();
		   }finally{
		    if(read!=null){//关闭流
		     try {
		      read.close();
		     } catch (IOException e) {
		      e.printStackTrace();
		     }
		    }
		   }
		     
		   return result; 
	}

}
