package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;

import java.util.List;

public interface IBorrowService extends IService<BorrowInfo> {

    Book borrowBook(int borrowId, int bookId, int userId);


    void returnBook(int borrowId, int bookId, int userId);

    List<BorrowInfo> getBorrowInfoByUserId(int userId);

    String getBorrowInfoByUserId(String user_id);
}
