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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")//数据库表的名称
@ApiModel(description = "读者实体类")
public class User {
    @ApiModelProperty(value = "用户ID",required = true)
    @TableId(value = "user_id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "用户名",required = true)
    @TableField(value = "user_name")
    private String username;

    @ApiModelProperty(value = "密码",required = true)
    @TableField(value = "user_pwd")
    private String password;

    @ApiModelProperty(value = "姓名",required = true)
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "性别",required = true) //性别：M男 F女 U未知 枚举类型
    @TableField(value = "user_gender")
    private String gender;

    @ApiModelProperty(value = "地址",required = true)
    @TableField(value = "user_address")
    private String address;

    @ApiModelProperty(value = "电话号码",required = true)
    @TableField(value = "user_phone")
    private String phone;



}
