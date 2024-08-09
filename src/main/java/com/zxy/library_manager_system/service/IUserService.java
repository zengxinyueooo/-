package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.Admin;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {


    List<Admin> loginAdmin(String username, String password);
    List<User> loginUser(String username, String password);

    void register(User user);


    List<User> getUserById(int id);

    void updateUserInfo(User user);

    List<Book> searchBookByName(String name);

    void borrowBook(int borrowId, int userId, int bookId);

    void returnBook(int borrow_id, int  userId, int bookId);

    List<BorrowInfo> getBorrowInfoByUserId(int userId);


}