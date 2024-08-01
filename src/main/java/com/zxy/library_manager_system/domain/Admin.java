package com.zxy.library_manager_system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "管理员实体类")
public class Admin {

    @TableField(value = "user_name")
    @ApiModelProperty(name = "username", value = "用户名",required = true)
    private String username;

    @TableField(value = "user_pwd")
    @ApiModelProperty(name = "password", value = "密码",required = true)
    private String password;
}
