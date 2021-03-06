<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<jsp:useBean id="loginBean" class="lyons.entity.Login" scope="session"/>
 	 <!-- 创建一个由class属性指定的类的实例，然后把它绑定到其名字由id属性给出的变量上 -->
	<% 
    				    String str = null;
    				    str = loginBean.getUsername();
    					if(str.equals("userNull")||str==null)
    					{
    					   HttpSession s= request.getSession(true);
                           s.invalidate();
    %>
    <meta http-equiv="refresh" content="0; url=<%= path %>/jsp/join/login.jsp"> 
   <% 					
    					}
    %>                    
<title>修改密码</title>
	<script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
</head>
<body>
	
	<%@ include file="/navbar.jsp" %>
		<jsp:useBean id="userBean" class="lyons.entity.Register" scope="request"/>
		<% request.setCharacterEncoding("UTF-8"); %>
		<div align="center">
			<form action="<%= path %>/control.PasswordValidation" method="post">
				<table border="1" cellpadding="10" cellspacing="1">
					<tr>
					
					
						<td>用户姓名:<input id="uname" name="username" value="<%= str %>" /></td>
						<td>原密码：<input type="password" name="oldpass" placeholder="*必填"/></td>
						<td>新密码：<input type="password" name="userpass" placeholder="*必填(6-16字符之间)"/></td>
					</tr>
					<tr>
						<td>重复密码：<input type="password" name="again_userpass" placeholder="*必填"/></td>
						<td>联系电话：<input type="text" name="phone" placeholder="*选填"/></td>
					</tr>
					<tr>
						<td>邮寄地址：<input type="text" name="address" placeholder="*选填"/></td>
						<td>真实姓名：<input type="text" name="realname" placeholder="选填"/></td>
					</tr>
						<tr>
							<td>
								状态:<FONT color=red><jsp:getProperty name="userBean" property="backNews"/></FONT>
							</td>
							<td>
								<input type="image" src="<%= path %>/image/page/submit.png" alt="submit" height="40" width="100"/>
							</td>
						</tr>
				</table>
				
			</form>
		
		</div>
		
		<script type="text/javascript">
			$("#uname").attr("readonly","true");
		</script>
</body>
</html>