package com.zxy.library_manager_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.library_manager_system.domain.*;
import com.zxy.library_manager_system.mapper.AdminMapper;
import com.zxy.library_manager_system.mapper.BookMapper;
import com.zxy.library_manager_system.mapper.UserMapper;
import com.zxy.library_manager_system.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return adminMapper.getAllBooks();
    }


    public List<Book> getBookById(int id) {
        return adminMapper.getBookById(id);
    }

    @Override
    public void saveBook(Book book) {adminMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        adminMapper.updateBook(book);
    }

    @Override
    public void deleteBook(int bookId) {
        adminMapper.deleteBook(bookId);
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            // 编写SQL查询语句，获取所有用户信息
            //String sql = "SELECT * FROM user_table";
            users = userMapper.selectList(new QueryWrapper<User>());
        } catch (Exception e) {
            // 异常处理
        }
        return users;
    }

    @Override
    public List<User> getUserById(int userId) {
        List<User> users = null;
    try {
        // 使用MyBatis的Mapper接口执行查询
        users = userMapper.getUserById(userId);
    } catch (Exception e) {
        // 异常处理
        e.printStackTrace();
    }
    return users;
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
