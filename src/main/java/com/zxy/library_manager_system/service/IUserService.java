package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;
import com.zxy.library_manager_system.domain.Result;

import java.util.List;

public interface IUserService extends IService<User> {


    User login(String username, String password);

    void register(User user);


    User getUserById(String id);

    void updateUserInfo(User user);

    List<Book> searchBookByName(String name);

    void borrowBook(int userId, int bookId);

    void returnBook(int userId, int bookId);

    List<BorrowInfo> getBorrowInfoByUserId(int userId);


}