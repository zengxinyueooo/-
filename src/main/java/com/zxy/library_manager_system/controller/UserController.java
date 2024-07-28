package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.domain.User;
import com.zxy.library_manager_system.service.IUserService;
import com.zxy.library_manager_system.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return new Result(true, "Login successful", user);
        } else {
            return new Result(false, "Login failed");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        try {
            userService.register(user);
            return new Result(true, "Registration successful", user);
        } catch (Exception e) {
            return new Result(false, "Registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/getUserById")
    public Result getUserById(@RequestParam String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new Result(true, user);
        } else {
            return new Result(false, "User not found");
        }
    }

    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody User user) {
        try {
            userService.updateUserInfo(user);
            return new Result(true, "User information updated");
        } catch (Exception e) {
            return new Result(false, "Update failed: " + e.getMessage());
        }
    }

    @GetMapping("/searchBookByName")
    public Result searchBookByName(@RequestParam String name) {
        List<Book> books = userService.searchBookByName(name);
        return new Result(true, books);
    }

    @GetMapping("/getBorrowInfo")
    public Result getBorrowInfoByUserId(@RequestParam int userId) {
        List<BorrowInfo> borrowInfoList = userService.getBorrowInfoByUserId(userId);
        return new Result(true, borrowInfoList);
    }

    @PostMapping("/returnBook")
    public Result returnBook(@RequestParam int userId, @RequestParam int bookId) {
        try {
            userService.returnBook(userId, bookId);
            return new Result(true, "Book returned successfully");
        } catch (Exception e) {
            return new Result(false, "Return failed: " + e.getMessage());
        }
    }

    @PostMapping("/borrowBook")
    public Result borrowBook(@RequestParam int userId, @RequestParam int bookId) {
        try {
            userService.borrowBook(userId, bookId);
            return new Result(true, "Book borrowed successfully");
        } catch (Exception e) {
            return new Result(false, "Borrow failed: " + e.getMessage());
        }
    }
}