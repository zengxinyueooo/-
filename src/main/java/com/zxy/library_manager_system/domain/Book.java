package com.zxy.library_manager_system.domain;

 /*book表
         1. id(唯一主键标识)
         2. name(书名)
         3. 作者
         4. 价格
         5. 简介
         6. 剩余数量*/

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book")//数据库表的名称
public class Book {
    @TableId(value = "id", type = IdType.AUTO )
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "author")
    private String author;

    @TableField(value = "price")
    private Integer price;

    @TableField(value = "introduction")
    private String introduction;

    @TableField(value = "remain")
    private Integer remain;
}
/*
@TableId
value属性指定了数据库表中主键字段的名称，这里指定为"id"。
type属性指定了主键生成策略，IdType.AUTO 表示使用数据库自增长的方式生成主键值。

@TableField
将实体类中的name属性映射到数据库表中的name字段上。
方便地实现实体类和数据库表之间的映射，简化了开发人员在进行数据库操作时的操作。*/
