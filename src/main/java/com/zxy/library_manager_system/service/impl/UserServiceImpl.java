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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService{

        @Autowired
        private UserMapper userMapper;


        @Autowired
        private BorrowMapper borrowMapper;

        @Autowired
        private BookMapper bookMapper;


    @Override
    public List<Admin> loginAdmin(String username, String password) {
        return userMapper.loginAdmin(username, password);
    }

    @Override
    public List<User> loginUser(String username, String password) {
        return userMapper.loginUser(username, password);
    }

    @Override
    public void register(User user) {
        // 检查手机号格式
        if (!isValidPhoneNumber(user.getPhone())) {
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
    public List<User> getUserById(int id) {
        List<User> users = userMapper.getUserById(id);
        for (User user : users) {
            if (user.getUsername() == null) {
                user.setUsername("default_username");
            }
            if (user.getPassword() == null) {
                user.setPassword("default_password");
            }
            if (user.getGender() == null) {
                user.setGender("unknown");
            }
            if (user.getAddress() == null) {
                user.setAddress("default_address");
            }
            if (user.getPhone() == null) {
                user.setPhone("default_phone");
            }
        }
        return users;
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
    public void borrowBook(int borrowId, int userId, int bookId) {
        Date borrowDate = new Date(); // 获取当前系统时间
        borrowMapper.borrowBook(borrowId, bookId, userId, borrowDate);
        bookMapper.decreaseBookQuantity(bookId);
    }

    @Override
    public void returnBook(int borrowId, int userId, int bookId) {
        Date returnDate = new Date(); // 获取当前系统时间
        borrowMapper.returnBook(borrowId, bookId, userId, returnDate);
        bookMapper.increaseBookQuantity(bookId);
    }

    @Override
    public List<BorrowInfo> getBorrowInfoByUserId(int userId) {
        return userMapper.getBorrowInfoByUserId(userId);
    }


}
