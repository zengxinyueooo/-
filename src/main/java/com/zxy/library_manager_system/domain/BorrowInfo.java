package com.zxy.library_manager_system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
 /*借阅信息
         1. 单号
         2. bookid
         3. userid
         4. 借出日期
         5. 归还日期
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("borrow_info")//数据库表的名称
public class BorrowInfo {

    @TableId(value = "borrowId", type = IdType.AUTO)
    private int borrowId;

    @TableField(value = "bookId")
    private int bookId;

    @TableField(value = "userId")
    private int userId;

    @TableField(value = "borrowDate")
    private Date borrowDate;

    @TableField(value = "returnDate")
    private Date returnDate;

}