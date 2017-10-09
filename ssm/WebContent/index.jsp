<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
	/* path = /Adapter */
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/*   basePath =       http         ://        localhost          :          8085          /Adapter/     */
%>
<html>
  <head>
   <%--  <base href="<%=basePath%>"> --%>
    <title>首页</title>
    <%@ include file="navbar.jsp" %>
	<meta http-equiv="pragma" content="no-cache"> 
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		<!--  ↑↑↑ 清除浏览器中的缓存，它和其它几句合起来用，就可以使你再次进入曾经访问过的页面时，ie浏览器必须从服务端下载最新的内容，达到刷新的效果。 --> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
		<!--   网页关键词设置 -->
	<meta http-equiv="description" content="This is my page">
		<!-- 网页描述 -->
  </head>

  <body>
 
 	 <jsp:useBean id="loginBean" class="com.xc.ssm.entity.Login" scope="session"/>
 	 <!-- 创建一个由class属性指定的类的实例，然后把它绑定到其名字由id属性给出的变量上 -->
 
 	 <% request.setCharacterEncoding("UTF-8"); %>
 		<ul class="user">
    			<li>
    				<%
    				    String str = null;
    				    str = loginBean.getUsername();
    					if(str.equals("userNull")||str==null)
    					{
    					   HttpSession s= request.getSession(true);
                           s.invalidate();
                        %>
	     					<a href="<%= path %>/login/login">登录</a>or<a href="<%= path %>/register/register">注册</a>
    					<%
    					return;
    					}
    				 %>
   						<dl>
   							<dt>
	    						<a>欢迎您,<b><font color="red"><%= str %></font></b></a>
	    						<a href="<%= path %>/login/exit"><font color="#CDC9C9">退出</font></a>
	    						<a href="<%= path %>/register/jumpupdate"><font color="#CDC9C9">修改密码</font></a>
	    						
   							</dt>
   						</dl>
    			</li>
    		</ul>
    		
    		<% 
                String value = null;
                value = request.getParameter("first");
                if(value!=null && "FP".equals(value))
                {%>	
                    <div>
                    <br><br><br>
                        <img src="image/page/ttt.jpg" width=50px height=50px /> 
                    </div>
                <%}
            %>
          
  </body>
</html>
