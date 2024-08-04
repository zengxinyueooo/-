package com.zxy.library_manager_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxy.library_manager_system.domain.Admin;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
管理员: 1. 图书管理(对书籍进行curd)
       2. 读者管理(查看和添加) 3. 借还管理(记录已借的书籍和未归还的书籍) 4. 对自己信息进行修改
*/

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {


    @Select("SELECT * FROM book")
    List<Book> getAllBooks();

    @Select("SELECT * FROM book WHERE book_id = #{bookId}")
    Book getBookById(@Param("bookId") int book_id);

    @Insert("INSERT INTO book (book_id, book_author, book_name, book_introduction, book_price, quantity) VALUES " +
            "(#{book.id}, #{book.author}, #{book.name}, #{book.introduction}, #{book.price}, #{book.remain})")
    int addBook(@Param("book")Book book);

    @Update("UPDATE book SET book_author = #{book.author}, book_name = #{book.name}, " +
            "book_introduction = #{book.introduction}, book_price = #{book.price}," +
            " quantity = #{book.remain} WHERE book_id = #{book.id}")
    int updateBook(@Param("book") Book book);

    @Delete("DELETE FROM book WHERE book_id = #{bookId}")
    int deleteBook(@Param("bookId") int book_id);

    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User getUserById(@Param("userId") int user_id);

    @Update("UPDATE user SET user_name = #{user.username}, user_pwd = #{user.password}, user_gender = #{user.gender}," +
            " name = #{user.name}, user_address = #{user.address}, user_phone = #{user.phone} WHERE user_id = #{user.id}")
    int updateUser(@Param("user") User user);

    @Select("SELECT * FROM borrow_info WHERE user_id = #{userId}")
    List<BorrowInfo> getBorrowedBooks(@Param("userId") int userId);

    @Select("SELECT * FROM borrow_info WHERE user_id = #{userId} AND return_date IS NULL and borrow_date IS NOT NULL")
    List<BorrowInfo> getUnreturnedBooks(@Param("userId") int user_id);

    @Update("UPDATE admin SET admin_pwd = #{newPassword} WHERE admin_name = #{adminname}")
    int updateAdminPassword(@Param("adminname") String admin_name, @Param("newPassword") String newPassword);

    @Update("UPDATE admin SET admin_name = #{admin.username}, admin_pwd = #{admin.password} WHERE admin_id = #{admin.id}")
    int updateAdmin(@Param("admin") Admin admin);
}