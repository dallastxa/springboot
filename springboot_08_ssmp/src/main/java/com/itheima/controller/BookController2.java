package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    IBookService bookService;

    @RequestMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        Boolean flag=bookService.save(book);
        return new R(flag,flag?"添加成功^_^":"添加失败-_-");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

/*    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage>page.getPages()){
            page=bookService.getPage((int) page.getPages(),pageSize);
        }
        return new R(true,page);
    }*/
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
/*        System.out.println("参数==>"+name);
        System.out.println("参数==>"+book);*/
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage>page.getPages()){
            page=bookService.getPage((int) page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }

}
