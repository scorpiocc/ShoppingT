package com.xc.ssm.entity;

import java.io.Serializable;
import java.util.LinkedList;

import org.springframework.stereotype.Component;

/**
 * 用户登陆实体类
 * @author
 *
 */
@Component
public class Login implements Serializable
{
	private static final long serialVersionUID = -69203680249861342L;
	private String username = "";
	private String backNews = "未登录";
	private LinkedList<String> car = null;      //购物车、定单
	
	
	public Login()
	{
		car = new LinkedList<String>();
	}
	
	public LinkedList<String> getCar()
	{
		return car;
	}
	public void setCar(LinkedList<String> car)
	{
		this.car = car;
	}
	public String getUsername()
	{
	    if (username.trim()=="")
        {
            return "userNull";
        }
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getBackNews()
	{
		return backNews;
	}
	public void setBackNews(String backNews)
	{
		this.backNews = backNews;
	}

}
