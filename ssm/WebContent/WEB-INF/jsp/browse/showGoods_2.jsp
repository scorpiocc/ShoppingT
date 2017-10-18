<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/index.jsp" %>
<%@page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>浏览商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>

  <body>	 
    	<jsp:useBean id="goods" class="com.xc.ssm.entity.Goods" scope="session"/>
  		<% request.setCharacterEncoding("UTF-8"); %>
  <br/><br/>
  

   
  
  <center>		
  	<table border="1" bordercolor="#00ff00" cellpadding="10" cellspacing="2" width="500" height="80">
  		  <caption><b>商品简略信息表</b><br></caption>
  		    <tr>
  		        <th>序号</th>
  		        <th>商品名称</th>
  		        <th>商品价格</th>
  		        <th>查看详情</th>
  		        <th>添加到购物车</th>
  		    </tr>
  		     
  		<%
  		
  			String keyWord = request.getParameter("keyWord");
  		
			
  			int PageSize = goods.getPageSize();            //每页显示的记录数
			//out.println("每页显示的记录数"+PageSize);
  			int totalPages = 2;
			if(request.getParameter("totalPages") != null){
			  totalPages =Integer.parseInt(request.getParameter("totalPages"));  //总页数
			}
			//out.println("总页数"+totalPages);
			int currentPage = goods.getCurrentPage();      //当前页码数
			
			 //检查是否用户自定义了页数
  			if(request.getParameter("newPageSize")!=null)
  			{
  			   PageSize = Integer.parseInt(request.getParameter("newPageSize"));    //PageSize每页显示的记录数
  			   currentPage = 1;//从第一页开始显示
  			}
  			//检查是否用户点击了下、上一页操作
  			if(request.getParameter("currentPage") != null)
  			{
  			   int newCurrentPageInt = Integer.parseInt(request.getParameter("currentPage"));
  			   //out.print("新页数:"+newCurrentPageInt);
  			   if(newCurrentPageInt <= totalPages && newCurrentPageInt>0)//下一页必须小于总页数，大于0
  			   {
  				 		currentPage = newCurrentPageInt;
  			   }else
  			       {
  			           currentPage = goods.getCurrentPage();//页数大于总页数或者小于零后，还原数据
  			       }
  			}
  			
  			
  			goods.setCurrentPage(currentPage);  //更新当前页码数
  			goods.setPageSize(PageSize);        //更新每页显示记录数
  			goods.setTotalPage(totalPages);		//更新总页数
  			
  			if(totalPages >= 1)
  			{
  			   if(goods.getCurrentPage()<1)
  			   {
  			       goods.setCurrentPage(goods.getTotalPage());//点击上一页提交时CurrentPage-1，但当前页面已经是最后一页，会出现此表达式会成立
  			   }
  			   
  			   if(goods.getCurrentPage()>goods.getTotalPage()) //点击下一页提交时CurrentPage+1，但当前页面已经是最后一页，会出现此表达式会成立
  			   {
  			      goods.setCurrentPage(1);
  			   }
  			} 
	 	
  		%>
  		 <%-- 数据：<%=(currentPage-1)*PageSize %> ---    当前显示条数：<%=PageSize %> ---   当前页数：<%=currentPage %>  --%>
  		 <c:forEach items="${com}" var="comm" varStatus="st" begin="<%=(currentPage-1)*PageSize %>" end="<%=((PageSize-1)+(currentPage-1)*PageSize) %>">
  			
  			 <%
		     //1,沃特篮球鞋,佛山,180,497,001.jpg,1
		     
		     
			String totals = "<form action='";
		     
			String shopCarButton1 = "/shopping/ToCar' method='post'><input type='hidden' name='GoodsCar' value='";
            String shopCarButton2 = "'><input type='submit' value='加入购物车'></form>";
            
   			String detail1 = "/shopping/info' method='post'><input type='hidden' name='detail' value='";
            String detail2 =  "'><input type='submit' value='商品详情'></form>"; 
                    
           
              %>  
  			 <c:if test="${st.count%2==0}"><tr bgcolor="#FFE4B5"></c:if>
  			 <c:if test="${st.count%2==1}"><tr bgcolor="#FFFACD"></c:if>	
  			 
  			               <td>${st.count}</td>
  			               <td>${comm.commodityName}</td>
  			               <td>${comm.commodityPrice}￥</td>
  			               <td> <%=totals %><%=path %><%= detail1 %>
  			               		${comm.commodityNumber},${comm.commodityName},${comm.commodityMade},${comm.commodityPrice},${comm.commodityBalance},${comm.commodityPic},${comm.commodityId}
  			               	   <%= detail2 %>
  			               </td>
  			               <td>
  			               	    <%=totals %><%=path %><%= shopCarButton1 %>
  			               		${comm.commodityNumber},${comm.commodityName},${comm.commodityMade},${comm.commodityPrice},${comm.commodityBalance},${comm.commodityPic},${comm.commodityId}
  			               	   <%= shopCarButton2 %>
  			               </td>
  			           </tr>
  		</c:forEach>
  		
  	</table>
  	
  	<br><%=currentPage %>/${totalPages}页 
  	
  	<table>
  	 <tr>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%=(currentPage-1) %>">
  	             <input type="hidden" name = keyWord  value = "<%=keyWord%>"> 
  	             <input type="hidden" name = totalPages  value = ${totalPages}> 
  	             <input type="submit" value="上一页">
  	         </form>
  	     </td>
  	     <td>
  	         <form action="" method="post">
  	             <input type="hidden" name=currentPage value="<%=(currentPage+1) %>">
  	             <input type="hidden" name = keyWord  value = "<%=keyWord%>"> 
  	             <input type="hidden" name = totalPages  value = ${totalPages}> 
  	             <input type="submit" value="下一页">
  	         </form>
  	     </td>
  	 </tr>
  	 
  	 <tr>
  	     <td><BR>
  	         <form action="" method="post">
  	            总计： ${fn:length(com)}条记录.每页显示<input type="text" name="newPageSize" value="<%= PageSize %>" size="2">条.
  	            	<input type="hidden" name = keyWord  value = "<%=keyWord%>"> 
  	                 <input type="submit" value="确定">
  	         </form>
  	     </td>
  	 </tr>
  	 
  	</table>
  	
   </center>
  </body>
</html>