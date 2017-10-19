package com.xc.ssm.handler;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.ssm.entity.Commodity;
import com.xc.ssm.entity.Goods;
import com.xc.ssm.entity.Login;
import com.xc.ssm.service.OrderFormService;
import com.xc.ssm.service.ShoppingService;

@Controller
@RequestMapping("/shopping")
public class HandlerShopping {
	@Resource
	private ShoppingService shoppingservice;
	@Resource
	private OrderFormService orderformservice;
	
	//查看购物车
	@RequestMapping("/ShopCar")
	public String Shopping_ShopCar(){
		return "shoppingCar/lookShoppingCar";
	}
	
	//浏览商品界面
	 @RequestMapping("/handler/{Key}")
	 public String Shopping_H(HttpServletRequest request, HttpServletResponse response,@PathVariable String Key,Model model){
		 response.setContentType("text/html;chartset=UTF-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int key = Integer.parseInt(Key);
		String keyWord = "";  //查找条件q
		keyWord = request.getParameter("keyWord");
		System.out.println("keyword:"+keyWord);
		String test = "";
		test = request.getParameter("newPageSize");
		System.out.println("新页数:"+test);
		
		response.setContentType("text/html;charset=UTF-8");
        
		Goods goods = null;
		Login username = null;
		

		HttpSession session = request.getSession(true);
		username = (Login)session.getAttribute("loginBean");
		goods = (Goods)session.getAttribute("goods");

		if (goods==null)
		{
			goods = new Goods();
			session.setAttribute("goods", goods);
		}
		if (username==null)
		{
		    username = new Login();
		    session.setAttribute("username", username);
		}

		  //判断用户是否登陆
		  String user = "";
          user = username.getUsername();//登陆者的用户名
          System.out.println("我是用户："+user);
          if (user.equals("userNull"))
          {
        	String backnews = "用户未登陆，请重新登陆";
            model.addAttribute("backnews", backnews);
             return "join/login";
          }
        
          double  PageSize; //数据总长度
          int currentPage;  //显示条数
          int  totalPages ; //总页数
          
          switch (key) {
		case 2:
			//根据Key浏览商品
			String keyword = request.getParameter("keyWord");
			System.out.println("查找条件为:"+keyword);
			List<Commodity> keysearch = shoppingservice.selectCommodityByKey(keyword);
			if(keysearch == null){
				model.addAttribute("searchinfo","亲,还没有此类商品噢,请更换关键字查询");
				return "browse/searchByKeyWord";
			}
			model.addAttribute("com", keysearch);
			System.out.println("根据Key浏览商品--查找添加成功！");
			//修改显示条数
			PageSize = keysearch.size(); //获取数据总长度
			if(request.getParameter("newPageSize")!=null){
				   currentPage =  Integer.parseInt(request.getParameter("newPageSize"));
				 System.out.println("当前显示条数"+currentPage);
			}else{
				  currentPage = goods.getPageSize();
				 System.out.println("显示默认条数"+currentPage);
			}
			totalPages  =  (int) Math.ceil(PageSize/currentPage);
			model.addAttribute("totalPages",totalPages);
			 
			
			return "browse/showGoods_2";
			
		case 3:
			//查看订单
			List<String> orderform = orderformservice.selectByUserName(user);
			model.addAttribute("OrderForm", orderform);
			System.out.println("查看订单--查找添加成功！");
			//修改显示条数
			double  FormPageSize = orderform.size(); //获取数据总长度
			System.out.println("获取到"+FormPageSize+"条结果");
			int FormcurrentPage ; 
			if(request.getParameter("newPageSize")!=null){
				FormcurrentPage =  Integer.parseInt(request.getParameter("newPageSize"));
				 System.out.println("当前订单显示条数"+FormcurrentPage);
			}else{
				FormcurrentPage = goods.getPageSize();
				 System.out.println("显示订单默认条数"+FormcurrentPage);
			}
			int  Formtotalpages  =  (int) Math.ceil(FormPageSize/FormcurrentPage);
			System.out.println("总共"+Formtotalpages+"页");
			model.addAttribute("FormTotalPages",Formtotalpages);
			 
			
			return "order/lookOrderForm";
			
			
			
		case 4:
			 //浏览商品
			List<Commodity> com = shoppingservice.selectCommodity();
			model.addAttribute("com", com );
			System.out.println("浏览商品--查找添加成功！");
			//修改显示条数
			 PageSize = com.size(); //获取数据总长度 
			if(request.getParameter("newPageSize")!=null){
				   currentPage =  Integer.parseInt(request.getParameter("newPageSize"));
				 System.out.println("当前显示条数"+currentPage);
			}else{
				  currentPage = goods.getPageSize();
				 System.out.println("显示默认条数"+currentPage);
			}
		    totalPages  =  (int) Math.ceil(PageSize/currentPage);
			model.addAttribute("totalPages",totalPages);
			 
			
			return "browse/showGoods_2";
			
		default:
			break;
		}
		return "../../index";
         
	 }
	 
	 //商品详情
	 @RequestMapping("/info")
	 public String Shopping_Infor(HttpServletRequest request, HttpServletResponse response,Model model){
		 response.setContentType("text/html;chartset=UTF-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		String detail = null;
		 if(request.getParameter("detail") != null){
			 detail = request.getParameter("detail");
			 System.out.println("商品详情:"+detail.trim());
		 }
		 model.addAttribute("detail",detail.trim());
		
		 return "browse/showDetail";
	 }
	 
	 //添加至购物车
	 @RequestMapping("/ToCar")
	 public String Shopping_PutToCar(HttpServletRequest request, HttpServletResponse response,Model model){
		 response.setContentType("text/html;chartset=UTF-8");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		String goods = null;
		goods =  request.getParameter("GoodsCar");
		
		if(goods == null){
			return "../../index";
		}else
		{
            String[] details = null;
            details = goods.split(",");//数组内储存的信息与数据库一致。
            
            //将物品信息放进模型中
            HttpSession session = request.getSession(true);
            Login loginBean = (Login)session.getAttribute("loginBean");
            LinkedList<String> car = null;
            car = loginBean.getCar();
          
            car.add(goods);
            loginBean.setCar(car);
            System.out.println("信息写入成功");

            model.addAttribute("goodsName", details[1]);
            return "browse/PutToCarReturn";
        }
		
	 }
	 //删除购物车商品
	 @RequestMapping("/DeleteGoodsFromCar/{Did}")
	 public String Shopping_DeleteGoods(HttpServletRequest request, HttpServletResponse response,@PathVariable String Did,Model model){
		 	response.setContentType("text/html;setchar=UTF-8");
	        try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				System.out.println("编码问题"+e);
				e.printStackTrace();
			}
	        int deleteID = -1;
	        deleteID =  Integer.parseInt(Did);
	        System.out.println("删除数组下标为："+deleteID);
	        
	        HttpSession session = request.getSession(true);
	        Login loginBean = (Login)session.getAttribute("loginBean");
	        LinkedList<String> car = null;
	        car = loginBean.getCar();
	        car.remove(deleteID);
	        loginBean.setCar(car);
		 
		 return "shoppingCar/lookShoppingCar";
	 }
	 @RequestMapping("/ByGoods")
	 public String Shopping_ByGoods(HttpServletRequest request, HttpServletResponse response,@PathVariable String Did,Model model){
		 	response.setContentType("text/html;setchar=UTF-8");
	        try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				System.out.println("编码问题"+e);
				e.printStackTrace();
			}
	        
	        
	        return "";
	 }

}

