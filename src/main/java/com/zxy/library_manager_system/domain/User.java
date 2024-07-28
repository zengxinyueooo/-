package com.zxy.library_manager_system.domain;

 /*user表
         1. id
         2. username
         3. password
         4. 姓名
         5. 性别
         6. 地址
         7. 电话*/

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book")//数据库表的名称
public class User {

    @TableId(value = "id", type = IdType.AUTO )
    private Integer id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "name")
    private String name;

    @TableField(value = "gender")  // 性别：M男 F女 U未知  枚举类型
    private String gender;

    @TableField(value = "address")
    private String address;

    @TableField(value = "phone")
    private String phone;

    public String getPhoneNumber() {
        return this.phone;
    }

    public String getPassword() {
        return this.password;
    }

    public Object getPageNo() {
    }
}
