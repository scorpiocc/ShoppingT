<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/index.jsp" %>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>

  <body>	 
  		
  	<br><br><br>
  	<center>
  	<font size=5 color=red><B>${goodsName}</B></font>&nbsp;已成功添加购物车
  	<br><br><br>
  	<a href="<%=path %>/shopping/handler/4">返回继续购物</a>
  	&nbsp;&nbsp;
  	<a href="<%=path %>/shopping/ShopCar">查看购物车</a>
  	</center>
   
  </body>
</html>