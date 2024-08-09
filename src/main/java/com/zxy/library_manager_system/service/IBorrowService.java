package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;

public interface IBorrowService extends IService<BorrowInfo> {

    Book borrowBook(int borrowId, int bookId, int userId);


    void returnBook(int borrowId, int bookId, int userId);

    String getBorrowInfoByUserId(int userId);


}
