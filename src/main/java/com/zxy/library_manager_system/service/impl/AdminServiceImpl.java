package com.zxy.library_manager_system.service.impl;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxy.library_manager_system.domain.*;
import com.zxy.library_manager_system.mapper.AdminMapper;
import com.zxy.library_manager_system.mapper.BookMapper;
import com.zxy.library_manager_system.mapper.UserMapper;
import com.zxy.library_manager_system.service.IAdminService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

// AdminServiceImpl.java
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Book> getAllBooks() {
        return BookMapper.getAllBooks();
    }


    public Book getBookById(int id) {
        return bookMapper.getById(id);
    }

    @Override
    public void saveBook(Book book) {
        bookMapper.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.update(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookMapper.delete(bookId);
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            // 编写SQL查询语句，获取所有用户信息
            String sql = "SELECT * FROM user_table";
            users = userMapper.selectList(new QueryWrapper<User>());
        } catch (Exception e) {
            // 异常处理
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        return adminMapper.getUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        adminMapper.updateUser(user);
    }

    @Override
    public List<BorrowInfo> getBorrowedBooks(int readerId) {
        return adminMapper.getBorrowedBooks(readerId);
    }

    @Override
    public List<BorrowInfo> getUnreturnedBooks(int readerId) {
        return adminMapper.getUnreturnedBooks(readerId);
    }


    @Override
    public void updateAdminPassword(String username, String newPassword) {
        adminMapper.updateAdminPassword(username, newPassword);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }



}
