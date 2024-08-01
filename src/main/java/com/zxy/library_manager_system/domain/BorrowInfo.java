package com.zxy.library_manager_system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "借阅信息实体类")
public class BorrowInfo {

    @TableId(value = "borrow_id", type = IdType.AUTO)
    @ApiModelProperty(value = "借阅单号",required = true)
    private int borrowId;

    @TableField(value = "book_id")
    @ApiModelProperty(value = "图书id",required = true)
    private int bookId;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id",required = true)
    private int userId;

    @TableField(value = "borrow_date")
    @ApiModelProperty(value = "借出日期",required = true)
    private Date borrowDate;

    @TableField(value = "return_date")
    @ApiModelProperty(value = "归还日期",required = true)
    private Date returnDate;

}