<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/WEB-INF/jsp/join/isLogin.jsp" %>
<%@ include file="/index.jsp" %>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
</head>
  <body>     
        <jsp:useBean id="goods" class="com.xc.ssm.entity.Goods" scope="session"/>
        <% request.setCharacterEncoding("UTF-8"); %>
  <br/><br/>
  <center>
  
        
    <table border="1" bordercolor="#00ff00" cellpadding="5" cellspacing="1" width="300" height="80">
          <caption><b>我的订单</b><br></caption>
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>购买数量</th>
            </tr>
        <% 
            /* CachedRowSetImpl rowSet = goods.getRowSet();// 获取储存在模型中的行信息
            if(rowSet==null)
            {
                out.print("商品数据库中没有哦");
                
            } */
            
            int orderPageSize = goods.getFormpageSize();            //每页显示的记录数
            out.println("每页显示的记录数"+orderPageSize);
            int FormtotalPages = 1;
			if(request.getParameter("FormTotalPages") != null){
				FormtotalPages =Integer.parseInt(request.getParameter("FormTotalPages"));  //总页数
			}
            int currentPage = goods.getCurrentPage();      //当前页码数
            
            
            //检查是否用户自定义了页数
            if(request.getParameter("ordernewPageSize")!=null)
            {
            	orderPageSize = Integer.parseInt(request.getParameter("ordernewPageSize"));
               currentPage = 1;//从第一页开始显示
            }
            //检查是否用户点击了下、上一页操作
            if(request.getParameter("FormcurrentPage") != null)
            {
               int newCurrentPageInt = Integer.parseInt(request.getParameter("FormcurrentPage"));
               if(newCurrentPageInt <= FormtotalPages && newCurrentPageInt>0)//下一页必须小于总页数，大于0
               {
                   currentPage = newCurrentPageInt;
               }else
                   {
                       currentPage = goods.getCurrentPage();//页数大于总页数或者小于零后，还原数据
                   }
            }
            goods.setCurrentPage(currentPage);  //更新当前页码数
  			goods.setFormpageSize(orderPageSize);        //更新每页显示记录数
  			goods.setTotalPage(FormtotalPages);		//更新总页数
            
        %> 
        <c:forEach items="${OrderForm}" var="order" varStatus="st" begin="<%=(currentPage-1)*orderPageSize %>" end="<%=((orderPageSize-1)+(currentPage-1)*orderPageSize) %>">
  			<c:if test="${st.count%2==0}"><tr bgcolor="#FFE4B5"></c:if>
  			 <c:if test="${st.count%2==1}"><tr bgcolor="#FFFACD"></c:if>	
  			 
  			     <td>${st.count}</td>
  			     <td>${order.commodityName}</td>
  			     <td>${order.sum}</td>
        </c:forEach>
    </table>
    
    <br><%=currentPage %>/${FormTotalPages}页 
    
    <table>
     <tr>
         <td>
             <form action="" method="post">
                 <input type="hidden" name=FormcurrentPage value="<%= (currentPage-1) %>">
                 <input type="hidden" name = FormTotalPages  value = "${FormTotalPages}"> 
                 <input type="submit" value="上一页">
             </form>
         </td>
         <td>
             <form action="" method="post">
                 <input type="hidden" name=FormcurrentPage value="<%= (currentPage+1) %>">
                 <input type="hidden" name = FormTotalPages  value = "${FormTotalPages}"> 
                 <input type="submit" value="下一页">
             </form>
         </td>
     </tr>
     
     <tr>
         <td><BR>
             <form action="" method="post">
                总计：${fn:length(OrderForm)}条记录.每页显示<input type="text" name="ordernewPageSize" value="<%= orderPageSize %>" size="2">条.
                     <input type="submit" value="确定">
             </form>
         </td>
     </tr>
     
    </table>
    
   </center>
  </body>
</html>