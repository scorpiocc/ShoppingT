package com.xc.chat;

import com.alibaba.fastjson.JSON;

public class JdChat {
		 public String chat(String infor){
			 TuLingApi tulingApi = new TuLingApi();
		        String re = "";
		        
		        String info = infor; // String | 请求内容，编码方 式为UTF-8
		        
		        String loc = "无锡"; // String | 位置信息，请求跟 地理位置相关的内 容时使用，编码方 式UTF-8
		        
		        String userid = "222"; // String | 开发者给自己的用 户分配的唯一标志 （对应自己的每一 个用户）
		        
		        String appkey = "dde76372c439197c1e134470c101161c"; // 
		        
		        try {
		            String result = tulingApi.turing(info,loc,userid,appkey);
		            re = result;
		            //System.out.println(result);
		        } catch (Exception e) {
		            System.err.println("API调用出错！！");
		            e.printStackTrace();
		        }
		        ChatEntity chat = JSON.parseObject(re, ChatEntity.class);  
		        String R_code = chat.getCode();
		        ChatEntity2 chat2 = JSON.parseObject(chat.getResult(), ChatEntity2.class);  
		        String R_text = chat2.getText();
				if("10000".equals(R_code)){
					System.out.println("chat:"+R_text);
					return R_text;
				}else{
					String R_error = chat.getMsg();
					return R_error;
				}
		 }
        
    
}
