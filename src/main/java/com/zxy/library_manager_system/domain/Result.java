package com.zxy.library_manager_system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author .29.
 * @create 2023-03-28 22:11
 *
 * 控制层返回结果的模型类，用于后端与前端进行数据格式统一，也可以称为`前后端数据协议`
 */
//使用lombok快速开发
@Data
@ApiModel(value = "返回类型")
public class Result<T> {
    @ApiModelProperty(value = "是否成功", example = "true")
    private boolean flag;
    @ApiModelProperty(value = "数据")
    private Object data;
    @ApiModelProperty(value = "提示信息",example = "成功")
    private String msg;

    public Result(boolean flag){
        this.flag = flag;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag, List<T> data) {
        this.flag = flag;
        this.data = data;
    }
    public Result(boolean success, String message, List<T> data) {
        this.flag = success;
        this.msg = message;
        this.data = data;
    }

   /* public Result(boolean success, String message, List<Admin> data) {
        this.flag = success;
        this.msg = message;
        this.data = data;
    }

    public Result(boolean success, String message, List<User> data) {
        this.flag = success;
        this.msg = message;
        this.data = data;
    }*/


    public Result() {
    }

    public Result(String msg){
        this.flag = false;
        this.msg = msg;
    }

    public Result(boolean flag,String msg){
        this.flag = flag;
        this.msg = msg;
    }


    public Result(boolean b, String user_login_successful, User user) {
    }

    public Result(boolean success, String message, Book borrowedBook) {
        this.flag = success;
        this.msg = message;
        this.data = borrowedBook;
    }
    public void setSuccess(boolean b) {
    }

    public void setMessage(String 用户名不能为空) {
    }
}
