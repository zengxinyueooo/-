package com.zxy.library_manager_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

//对于静态方法无法直接在接口中使用MyBatis的注解，因为MyBatis是通过接口的实现类来执行SQL操作的

@Mapper
public interface BorrowMapper extends BaseMapper<BorrowInfo > {


    @Insert("INSERT INTO borrow_info (borrow_id, book_id, user_id, borrow_date) VALUES (#{borrowId}, #{bookId}, #{userId}, #{borrowDate})")
    void borrowBook(@Param("borrowId") int borrow_id, @Param("bookId") int book_id, @Param("userId") int user_id, @Param("borrowDate") Date borrow_date) ;

    @Insert("INSERT INTO borrow_info (borrow_id,book_id, user_id, return_date) VALUES (#{borrowId}, #{bookId}, #{userId}, #{returnDate})")
     void returnBook(@Param("borrowId") int borrow_id, @Param("bookId") int book_id, @Param("userId") int user_id, @Param("returnDate") Date return_date);

    @Select("select * from book where user_id = #{user_id}")
     String getBorrowInfoByUserId(@Param("user_id") String user_id);

    @Select("SELECT * FROM book WHERE book_id = #{bookId}")
    Book getBookInfoById(@Param("bookId") int book_id);
}
