package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void testGetById() {
        bookMapper.selectById(1);
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookMapper.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(19);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookMapper.updateById(book);
    }
    @Test
    void testDelete(){
        bookMapper.deleteById(19);
    }

    @Test
    void testGetAll(){
        bookMapper.selectList(null);
    }

    @Test
    void testGetPage(){
        IPage page=new Page(1,5);
        bookMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","计");
        bookMapper.selectList(queryWrapper);
    }

    @Test
    void testGetBy2(){
        String name=null;
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
        //if(name!=null)lqw.like(Book::getName,name);
        lqw.like(name!=null,Book::getName,name);
        bookMapper.selectList(lqw);
    }

}
