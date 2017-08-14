<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="lyons.user.entity.User"%>
<%
	
	User Logined = (User)session.getAttribute("loginBean");
	if(Logined==null)
	{
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
		response.sendRedirect(basePath+"jsp/join/login.jsp");
	}
%>



