<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="isLogin.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆中...</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="refresh" content="1; url=<%= path %>/login/index"> 
	
	<!-- <link rel="stylesheet" type="text/css" href="<%= path %>/css/nav.css">  -->

  </head>
  
  <body>
  
  		<jsp:useBean id="loginBean" class="com.xc.ssm.entity.Login" scope="session"/>
   		<% request.setCharacterEncoding("UTF-8"); %>
   		
   		<%
			if(loginBean.getBackNews()=="用户名或者密码错误"||loginBean.getBackNews()==null)
			{%>
			
				登录失败，请<a href="<%= path %>/login/login">重新登录</a>or<a href="<%= path %>/register/register">注册</a>
			<%}else
				{%>
				<b><font color="red"><%=loginBean.getBackNews() %></font></b>
				
			1秒后跳转到首页.....
				<%}
    	%>  	

  </body>
</html>
