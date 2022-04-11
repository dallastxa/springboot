package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.Book;

//control+o
public interface IBookService extends IService<Book> {

    public Boolean modify(Book book);

    public Boolean delete(Integer id);

    public IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
