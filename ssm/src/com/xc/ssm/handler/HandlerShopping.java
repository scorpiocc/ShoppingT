package com.xc.ssm.handler;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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
import com.xc.ssm.entity.OrderForm;
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
          double  FormPageSize; //订单数据总长度
          int FormcurrentPage ; //订单显示条数
          
          
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
			FormPageSize = orderform.size(); //获取数据总长度
			System.out.println("获取到"+FormPageSize+"条结果");
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
	        System.out.println("开始删除购物车商品！");
	        int deleteID = -1;
	        deleteID =  Integer.parseInt(Did);
	        System.out.println("删除数组下标为："+deleteID);
	        
	        HttpSession session = request.getSession(true);
	        Login loginBean = (Login)session.getAttribute("loginBean");
	        LinkedList<String> car = null;
	        car = loginBean.getCar();
	        car.remove(deleteID);
	        loginBean.setCar(car);
	        System.out.println("删除成功！");
		 return "shoppingCar/lookShoppingCar";
	 }
	 @RequestMapping("/ByGoods")
	 public String Shopping_ByGoods(HttpServletRequest request, HttpServletResponse response,Model model){
		 	response.setContentType("text/html;setchar=UTF-8");
	        try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				System.out.println("编码问题"+e);
				e.printStackTrace();
			}
	        System.out.println("开始结算！");
	        //从模型中直接拿取购物车信息
	        HttpSession session = request.getSession(true);
	        Login loginBean = (Login)session.getAttribute("loginBean");
	        String userName = "myNull";
	        userName = loginBean.getUsername();
	        LinkedList<String> car = null;
	        car = loginBean.getCar();
	        
	        if (car.size()!=0)
	        {
	            boolean falg = false;
	        
	        for (int i = 0,m=car.size(); i < m; i++)
            {
                    String[] goods = null;
                    goods = car.get(i).split(",");
                    OrderForm order = new OrderForm();//创建订单对象
                    order.setUsername(userName); //添加订单用户名
                    order.setSum(1L);            //默认先为1
                    Commodity commodity = new  Commodity(); //创建商品对象
                    for (int j = 0,n=goods.length; j < n; j++)
                    {
                        switch (j)
                        {
                            case 0:
                                    String commodity_number = null;
                                    commodity_number = goods[0];
                                    commodity.setCommodityNumber(commodity_number); //商品编号ID
                                break;
                            case 1:
                                    String commodity_name= null;
                                    commodity_name = goods[1];
                                    order.setCommodityName(commodity_name); //订单商品名称
                                break;
                            case 2:
                                break;
                            case 3:
                                    Double commodity_price = 0.00;
                                    commodity_price = Double.parseDouble(goods[3]);
                                    order.setCommodityPrice(BigDecimal.valueOf(commodity_price)); //订单商品价格
                                break;
                            case 4:
                                    int commodity_balance = -1;
                                    System.out.println(Integer.parseInt(goods[4]));
                                    commodity_balance = Integer.parseInt(goods[4])-1;//目前是默认每次修改一个
                                    System.out.println(commodity_balance);
                                    if (commodity_balance >= 0)
                                    {
                                        commodity.setCommodityBalance(commodity_balance); //商品库存数量
                                    }else 
                                        {
                                            String failNumber = "数据库中商品不足";
                                            model.addAttribute("failNumber", failNumber);
                                            return "shoppingCar/ByGoodsReturn";//提示商品不足
                                        }
                                break;
                            default:
                                System.out.println("for循环j默认结束1");
                                break;
                        }
                        System.out.println("for循环j结束,第"+j+"次");
                    }
                    //执行sql
                    int shopR  = shoppingservice.updateStock(commodity); //更新库存sql
                    int orderR = orderformservice.insertOrderForm(order);//插入订单sql
                    
                    if(shopR != 1 || orderR != 1){
                    	String failNumber = "sql执行失败";
                        model.addAttribute("failNumber", failNumber);
                        return "shoppingCar/ByGoodsReturn";//提示商品不足
                    }else{
                    	System.out.println(i+"此次循环商品购买成功");
                        falg = true;//此次循环商品购买成功
                    }
            }
	       
	        if (falg==true)
            {
                car.clear();
                String successBackNews = "您已将购物车中的商品买回家了";
                model.addAttribute("failNumber", successBackNews);
                return "shoppingCar/ByGoodsReturn"; 
            }
	 }
	        return "../../index";
	 }
	 
	

}

