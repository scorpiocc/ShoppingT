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
	<meta http-equiv="expires" content=z"0">    
	<jsp:useBean id="loginBean" class="com.xc.ssm.entity.Login" scope="session"/>
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
		<jsp:useBean id="userBean" class="com.xc.ssm.entity.Register" scope="request"/>
		<% request.setCharacterEncoding("UTF-8"); %>
		<div align="center">
			<form action="<%= path %>/register/updateUser" method="post">
				<table border="1" cellpadding="10" cellspacing="1">
					<tr>
					
					
						<td>用户姓名:<input id="uname" name="username" value="<%= str %>" /></td>
						<td>原密码：<input type="password" name="oldpass" placeholder="*必填"/></td>
						<td>新密码：<input id="pass" type="password" name="userpass" placeholder="*必填(6-16字符之间)" onkeyup="validate()"/></td>
					</tr>
					<tr>
						<td>重复密码：<input id="newpass" type="password" name="again_userpass" placeholder="*必填" onkeyup="validate()"/></td>
						<td>联系电话：<input type="text" name="phone" placeholder="*选填"/></td>
						<td><span id="tishi"></span></td>
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
								<input type="image"  id="submit" src="<%= path %>/image/page/submit.png" alt="submit" height="40" width="100"/>
							</td>
						</tr>
			</table>
				
			</form>
		
		</div>
		
		<script type="text/javascript">
			$("#uname").attr("readonly","true");
			function validate() {
              var pwd1 = document.getElementById("pass").value;
              var pwd2 = document.getElementById("newpass").value;
		//<!-- 对比两次输入的密码 -->
			if($("#pass").val().length>5 && $("#pass").val().length<17){
			if(pwd1 == pwd2 ) {
                  document.getElementById("tishi").innerHTML="<font color='green'>√</font>";
                  document.getElementById("submit").disabled = false;
              }
              else {
                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
              }
         	}else{
         		document.getElementById("tishi").innerHTML="<font color='red'>密码长度为6-17</font>";
                document.getElementById("submit").disabled = true;
         	}
		}
              
		</script>
</body>
</html>