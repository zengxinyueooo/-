package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;
import com.zxy.library_manager_system.mapper.UserMapper;
import com.zxy.library_manager_system.service.IUserService;
import com.zxy.library_manager_system.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "读者功能")
public class UserController {

    @Autowired
    private IUserService userService;

    Result result;

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return new Result(true, "Login successful", user);
        } else {
            return new Result(false, "Login failed");
        }
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public Result registerUser(@RequestBody User user) {
        Result result = new Result();

        // 检查必填字段是否为空
        if (user.getId() == null || user.getId().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("Id不能为空");
            return result;
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("用户名不能为空");
            return result;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("密码不能为空");
            return result;
        }
        if (user.getGender() == null || user.getGender().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("性别不能为空");
            return result;
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("姓名不能为空");
            return result;
        }
        if (user.getAddress() == null || user.getAddress().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("地址不能为空");
            return result;
        }
        if (user.getPhone() == null || user.getPhone().isEmpty()) {
            result.setSuccess(false);
            result.setMessage("手机号不能为空");
            return result;
        }

        try {
            userService.register(user);
            result.setFlag(true);
            result.setMsg("注册成功");
        } catch (IllegalArgumentException e) {
            result.setFlag(false);
            result.setMsg(e.getMessage());
        }

        return result;
    }


    @GetMapping("/getUserById")
    @ApiOperation("根据ID查看用户信息")
    public Result getUserById(@RequestParam String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new Result(true, user);
        } else {
            return new Result(false, "User not found");
        }
    }

    @PostMapping("/updateUserInfo")
    @ApiOperation("修改用户信息")
    public Result updateUserInfo(@RequestBody User user) {
        try {
            userService.updateUserInfo(user);
            return new Result(true, "User information updated");
        } catch (Exception e) {
            return new Result(false, "Update failed: " + e.getMessage());
        }
    }

    @GetMapping("/searchBookByName")
    @ApiOperation("根据书名搜索书籍")
    public Result searchBookByName(@RequestParam String name) {
        List<Book> books = userService.searchBookByName(name);
        return new Result(true, books);
    }

    @GetMapping("/getBorrowInfo")
    @ApiOperation("根据用户ID获取用户借阅信息")
    public Result getBorrowInfoByUserId(@RequestParam String userId) {
        String borrowInfoList = userService.getBorrowInfoByUserId(userId);
        return new Result(true, borrowInfoList);
    }

    @PostMapping("/returnBook")
    @ApiOperation("归还书籍")
    public Result returnBook(@RequestParam int borrow_id, @RequestParam String userId, @RequestParam int bookId) {
        try {
            userService.returnBook(borrow_id, userId, bookId);
            return new Result(true, "Book returned successfully");
        } catch (Exception e) {
            return new Result(false, "Return failed: " + e.getMessage());
        }
    }

    @PostMapping("/borrowBook")
    @ApiOperation("借阅书籍")
    public Result borrowBook(@RequestParam int borrowId, @RequestParam String userId, @RequestParam int bookId) {
        try {
            userService.borrowBook(borrowId, userId, bookId);
            return new Result(true, "Book borrowed successfully");
        } catch (Exception e) {
            return new Result(false, "Borrow failed: " + e.getMessage());
        }
    }
}