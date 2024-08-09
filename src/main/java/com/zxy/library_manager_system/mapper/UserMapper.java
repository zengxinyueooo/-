package com.zxy.library_manager_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxy.library_manager_system.domain.Admin;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/*方法上的SQL语句也加上了对应的注解，如@Select、@Insert、@Update，用于指定对应的数据库操作。
这样可以直接在Mapper接口中配置SQL语句，而不需要额外的Mapper XML文件。*/

/*@Param注解用于给方法参数起一个别名，以便在SQL语句中引用这些参数
* 不必直接使用方法参数的名称。这样做的好处是可以提高代码的可读性和可维护性*/

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {



    @Insert("insert into user(user_id, user_name, user_pwd, name, user_gender, user_address, user_phone) " +
            "values(#{user.id}, #{user.username}, #{user.password}, #{user.name}, #{user.gender}, #{user.address}, #{user.phone})")
    @Transactional
    void register(@Param("user")  User user);
    //insert into 表名（表中字段） values (类中字段)
    /*@Transactional注解表示这个方法需要在一个事务中执行，即在这个方法内部的数据库操作要么全部成功，要么全部失败。
    如果有异常发生，事务会回滚到之前的状态，保证数据的一致性。*/


    @Select("select * from user where user_id = #{id}")
    List<User> getUserById(@Param("id") int user_id);//select * 的 返回的是List类型 不是User类型


    /*@Update("update user set user_name = #{user.username}, user_pwd = #{user.password}, name = #{user.name}," +
            " user_gender = #{user.gender}, user_address = #{user.address}, user_phone = #{user.phone} where user_id = #{user.id}")*/
    void updateUserInfo(@Param("user") User user);


    @Select("select * from book where book_name like #{book_name}")
    List<Book> searchBookByName(String book_name);

    @Select("select * from borrow_info where user_id = #{userId}")
    List<BorrowInfo> getBorrowInfoByUserId(@Param("userId") int user_id);

    @Insert("insert into borrow_info(user_id, book_id, borrow_date) values(#{userId}, #{bookId}, #{borrowDate})")
    void borrowBook(@Param("userId") int  user_id, @Param("bookId") int book_id, @Param("borrowDate") Date borrow_date);

    @Update("update borrow_info set return_date = #{returnDate} where borrow_id = #{borrowId} and user_id = #{userId} and book_id = #{bookId}")
    void returnBook(@Param("borrowId") int borrow_id, @Param("userId") int  user_id, @Param("bookId") int book_id);

    @Update("update book set quantity = quantity - 1 where bookId = #{bookId}")
    void decreaseBookQuantity(@Param("bookId") int bookId);

    @Update("update book set quantity = quantity + 1 where bookId = #{bookId}")
    void increaseBookQuantity(@Param("bookId") int bookId);


    @Select("select * from admin where admin_name = #{uname} and admin_pwd = #{pwd}")
    List<Admin> loginAdmin(@Param("uname")String admin_name, @Param("pwd")String admin_pwd);

    @Select("select * from user where user_name = #{uname} and user_pwd = #{pwd}")
    List<User> loginUser(@Param("uname")String user_name, @Param("pwd")String user_pwd);
}
