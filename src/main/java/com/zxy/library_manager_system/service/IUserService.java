package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {


    User login(String username, String password);

    void register(User user);


    User getUserById(String id);

    void updateUserInfo(User user);

    List<Book> searchBookByName(String name);

    void borrowBook(int borrowId, String userId, int bookId);

    void returnBook(int borrow_id, String  userId, int bookId);

    String getBorrowInfoByUserId(String userId);


}