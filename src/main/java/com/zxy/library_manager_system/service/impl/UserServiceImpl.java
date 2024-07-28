package com.zxy.library_manager_system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.library_manager_system.domain.Admin;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;
import com.zxy.library_manager_system.mapper.BookMapper;
import com.zxy.library_manager_system.mapper.BorrowMapper;
import com.zxy.library_manager_system.mapper.UserMapper;
import com.zxy.library_manager_system.service.IUserService;
import com.zxy.library_manager_system.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService{

        @Autowired
        private UserMapper userMapper;
        @Autowired
        BookMapper BookService;


    @Override
    public User login(String username, String password) {
        User admin = userMapper.login(username, password);
        if (admin != null) {
            return admin;
        } else {
            User user = userMapper.login(username, password);
            if (user != null) {
                return user;
            } else {
                return null;
            }
        }
    }

    @Override
    public void register(User user) {
        // 检查手机号格式
        if (!isValidPhoneNumber(user.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        // 检查密码长度
        if (user.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        userMapper.register(user);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // 实现手机号格式校验逻辑，这里只是一个示例
        return phoneNumber.matches("\\d{11}");
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateUserInfo(user);
    }

    @Override
    public List<Book> searchBookByName(String name) {
        return userMapper.searchBookByName(name);
    }

    @Override
    public void borrowBook(int userId, int bookId) {
        Date borrowDate = new Date(); // 获取当前系统时间
        BorrowMapper.borrowBook(userId, bookId, borrowDate);
        BookMapper.decreaseBookQuantity(bookId);
    }

    @Override
    public void returnBook(int userId, int bookId) {
        Date returnDate = new Date(); // 获取当前系统时间
        BorrowMapper.returnBook(userId, bookId, returnDate);
        BookMapper.increaseBookQuantity(bookId);
    }

    @Override
    public List<BorrowInfo> getBorrowInfoByUserId(int userId) {
        return BorrowMapper.getBorrowInfoByUserId(userId);
    }



}
