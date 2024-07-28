package com.zxy.library_manager_system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  admin表
         1. 账号
         2. 密码*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("admin")//数据库表的名称
public class Admin {

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;
}
