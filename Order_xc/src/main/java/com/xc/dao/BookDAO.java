package com.xc.dao;

import com.xc.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* Created by 616067216@qq.com on 2017-07-10 09:23:59.
* 图书数据访问接口
*/
public interface BookDAO {
/**
* 获得所有图书
*/
public List<Book> getAllBooks();
    /**
    * 根据图书编号获得图书对象
    */
    public Book getBookById(@Param("id") int id);
    /**
    * 添加图书
    */
    public int add(Book entity);
    /**
    * 根据图书编号删除图书
    */
    public int delete(int id);
    /**
    * 更新图书
    */
    public int update(Book entity);
    }