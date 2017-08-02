package com.xc.t;

import java.util.ArrayList;

public class Test001 {
	public static void main(String[] args) {
		String a = "/DATA/apptemplate/demo///reportForm/user/charterOrder_AT/2017/07/31/5190020170731013559724.xls";
		if(a.indexOf("charterOrder_AT")!=-1){ 
			System.out.println("存在");
		}else{
			System.out.println("不存在");
		}
		
	        ArrayList list = new ArrayList();
	        int[] array1 = {1,2,3,4,5};
	        int[] array2 = {6,7,8,9,10};
	         
	        list.add(array1);
	        list.add(array2);
	         
	        for(int j = 0 ; j < list.size() ; j++)
	        {
	            int[] array = (int[])list.get(j);
	            for(int i = 0; i < array.length ; i++)
	            {
	                System.out.print(array[i] + " ");
	            }
	        }
	    
	}
}
