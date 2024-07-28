package com.zxy.library_manager_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.mapper.BookMapper;
import com.zxy.library_manager_system.mapper.BorrowMapper;
import com.zxy.library_manager_system.service.IBorrowService;
import com.zxy.library_manager_system.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, BorrowInfo > implements IBorrowService {


    @Autowired
    private BorrowMapper borrowMapper;


    @Override
    public void borrowBook(int bookId, int userId) {
        Date borrowDate = new Date(); // 获取当前系统时间
        BorrowMapper.borrowBook(bookId, userId, borrowDate);
        // 假设BookMapper.decreaseBookQuantity(bookId)是一个减少图书数量的方法
        BookMapper.decreaseBookQuantity(bookId);
    }


    @Override
    public void returnBook(int bookId, int userId, Date borrowDate) {
        Date returnDate = new Date(); // 获取当前系统时间
        BorrowMapper.returnBook(bookId, userId, returnDate);
    }

    @Override
    public List<BorrowInfo> getBorrowInfoByUserId(int userId) {
        return BorrowMapper.getBorrowInfoByUserId(userId);
    }
}
