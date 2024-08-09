package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.zxy.library_manager_system.domain.*;

import java.util.List;

public interface IAdminService extends IService<Admin> {

    public List<Book> getAllBooks();


    public List<Book> getBookById(int bookId);
    public void saveBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int bookId);

    public List<User> getAllUsers();
    public List<User> getUserById(int userId);


    public void updateUser(User user);

    public List<BorrowInfo> getBorrowedBooks(int readerId);
    public List<BorrowInfo> getUnreturnedBooks(int readerId);

    public void updateAdminPassword(String username, String newPassword);

    public void updateAdmin(Admin admin);
}
