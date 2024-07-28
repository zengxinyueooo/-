package com.zxy.library_manager_system.domain;

import com.zxy.library_manager_system.domain.Admin;
import com.zxy.library_manager_system.domain.User;
import lombok.Data;

/**
 * @author .29.
 * @create 2023-03-28 22:11
 *
 * 控制层返回结果的模型类，用于后端与前端进行数据格式统一，也可以称为`前后端数据协议`
 */
//使用lombok快速开发
@Data
public class Result {
    private boolean flag;
    private Object data;
    private String msg;

    public Result(boolean flag){
        this.flag = flag;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

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

    public Result(boolean b, String admin_login_successful, Admin admin) {
    }

    public Result(boolean b, String user_login_successful, User user) {
    }
}
