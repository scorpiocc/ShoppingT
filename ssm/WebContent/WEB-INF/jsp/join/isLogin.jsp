<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.xc.ssm.entity.Login"%>
<%
	
	Login Logined = (Login)session.getAttribute("loginBean");
	if(Logined==null)
	{
		response.sendRedirect("join/login");
	}
%>



