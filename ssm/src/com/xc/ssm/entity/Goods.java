package com.xc.ssm.entity;


import org.springframework.stereotype.Component;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 商品实体类
 * @author 
 *
 */
@Component
public class Goods 
{
	
	CachedRowSetImpl rowSet = null; //表中所有的行集对象
	
	private int pageSize = 5;	//浏览商品每页显示多少条记录(默认为5条)
	private int FormpageSize = 5;   //订单默认显示条数
	private int currentPage = 1;//当前页数
	private int totalRecord = 1;//总记录数
	private int totalPage = 1;	 //总页数
	
	public Goods(){}
	
	public Goods(CachedRowSetImpl rowSet, int pageSize, int formpageSize,
			int currentPage, int totalRecord, int totalPage) {
		super();
		this.rowSet = rowSet;
		this.pageSize = pageSize;
		this.FormpageSize = formpageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
	}

	public CachedRowSetImpl getRowSet()
    {
        return rowSet;
    }

    public void setRowSet(CachedRowSetImpl rowSet)
    {
        this.rowSet = rowSet;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getFormpageSize() {
  		return FormpageSize;
  	}

  	public void setFormpageSize(int formpageSize) {
  		this.FormpageSize = formpageSize;
  	}

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getTotalRecord()
    {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord)
    {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

	
}