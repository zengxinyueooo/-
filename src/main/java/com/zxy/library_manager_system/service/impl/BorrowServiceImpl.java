package com.zxy.library_manager_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.mapper.BookMapper;
import com.zxy.library_manager_system.mapper.BorrowMapper;
import com.zxy.library_manager_system.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, BorrowInfo > implements IBorrowService {


    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookMapper bookMapper;


    @Transactional
    public Book borrowBook(int borrow_id, int bookId, int userId) {
        Date borrowDate = new Date(); // 获取当前系统时间
        borrowMapper.borrowBook(borrow_id, bookId, userId, borrowDate);
        bookMapper.decreaseBookQuantity(bookId);
        // 假设borrowMapper.getBookInfoById(bookId)是一个根据bookId查询书籍信息的方法
        Book borrowedBook = borrowMapper.getBookInfoById(bookId);

        return borrowedBook;
    }



    @Override
    public void returnBook(int borrow_id, int bookId, int userId) {
        Date returnDate = new Date(); // 获取当前系统时间
        borrowMapper.returnBook(borrow_id, bookId, userId, returnDate);
    }



    @Override
    public String getBorrowInfoByUserId(int user_id) {
        return bookMapper.getBorrowInfoByUserId(user_id);
    }
}
