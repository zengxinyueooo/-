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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book") // 数据库表的名称
@ApiModel(description = "图书实体类")
public class Book {

    @ApiModelProperty(value = "图书ID", required = true)
    @TableId(value = "book_id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "图书名称", required = true)
    @TableField(value = "book_name")
    private String name;

    @ApiModelProperty(value = "作者", required = true)
    @TableField(value = "book_author")
    private String author;

    @ApiModelProperty(value = "价格", required = true)
    @TableField(value = "book_price")
    private Double price;

    @ApiModelProperty(value = "简介", required = true)
    @TableField(value = "book_introduction")
    private String introduction;

    @ApiModelProperty(value = "库存", required = true)
    @TableField(value = "quantity")
    private Integer remain;


    public boolean decreaseBookQuantity() {
        return false;
    }

    // 可能需要调整为实例方法
    public boolean increaseBookQuantity() {
        return false;
    }
}
/*
@TableId
value属性指定了数据库表中主键字段的名称，这里指定为"id"。
type属性指定了主键生成策略，IdType.AUTO 表示使用数据库自增长的方式生成主键值。

@TableField
将实体类中的name属性映射到数据库表中的name字段上。
方便地实现实体类和数据库表之间的映射，简化了开发人员在进行数据库操作时的操作。*/
