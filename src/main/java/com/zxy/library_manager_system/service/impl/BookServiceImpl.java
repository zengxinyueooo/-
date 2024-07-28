package com.zxy.library_manager_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.mapper.BookMapper;
import com.zxy.library_manager_system.service.IBookService;
import com.zxy.library_manager_system.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService{

    @Autowired
    BookMapper mapper;

    @Override
    public List<Book> getAllBooks(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return BookMapper.getAllBooks();
    }

    @Override
    public void decreaseBookQuantity(int bookId) {
        Book.decreaseBookQuantity(bookId);
    }

    @Override
    public void increaseBookQuantity(int bookId) {
        Book.increaseBookQuantity(bookId);
    }

    /*通过 @Autowired 注解，可以将该Mapper接口的实现类自动注入到 BookServiceImpl 类中的 mapper 变量中，
    在业务逻辑中可以直接使用该mapper变量进行数据库操作。*/
}

/*
ServiceImpl<BookMapper, Book>
表示需要注入的Mapper接口，而 Book 表示该Service类操作的实体类。*/
