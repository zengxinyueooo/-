package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.Result;

import java.util.Date;
import java.util.List;

public interface IBorrowService extends IService<BorrowInfo> {

    void borrowBook(int bookId, int userId);


    void returnBook(int bookId, int userId, Date borrowDate);

    List<BorrowInfo> getBorrowInfoByUserId(int userId);
}
