package com.zxy.library_manager_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxy.library_manager_system.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zxy
 */

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Update("UPDATE book SET quantity = quantity - 1 WHERE book_id = #{id}")
    void decreaseBookQuantity(@Param("id") int book_id);

    @Update("UPDATE book SET quantity = quantity + 1 WHERE book_id = #{id}")
    void increaseBookQuantity(@Param("id") int book_id);

    @Select("SELECT * FROM book")
    List<Book> getAllBook();

    @Insert("INSERT INTO book (title, author, isbn) VALUES (#{title}, #{author}, #{isbn})")
    void save(Book book);

    @Update("UPDATE book SET title = #{title}, author = #{author}, isbn = #{isbn} WHERE id = #{id}")
    void update(Book book);

    @Delete("DELETE FROM book WHERE book_id = #{bookId}")
    void delete(@Param("bookId") int book_id);

    @Select("SELECT * FROM book WHERE book_id = #{id}")
    Book getById(@Param("id") int book_id);

    @Select("SELECT * FROM borrow_info WHERE user_id = #{id}")
    String getBorrowInfoByUserId(@Param("id") int user_id);

    @Select("SELECT * FROM book")
    List<Book> getAllBooks();
}