package com.xc.ssm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordMd5 {
	public String encryption(String plainText) {
        String md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
 
            int i;
 
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
 
            md5 = buf.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("加密错误:"+e);
        }
        return md5;
    }
	
	/*public  String removeAllBlank(String s) {
        String newStr = "";
         // 将字符串转成字符数组
         char[] c = s.toCharArray();
         // 遍历字符数组
         for ( char element : c) {
              // 如果不是空格，往newStr上拼接，不然，舍弃
              if ( element != ' ') {
                   newStr += element;
             }
        }
         return newStr;
  }*/


}
