package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.*;
import com.zxy.library_manager_system.service.IAdminService;
import com.zxy.library_manager_system.service.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// AdminController.java
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员功能")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IBookService bookService;

    @GetMapping("/books/all")
    @ApiOperation(value = "获取全部书籍")
    public ResponseEntity<Result> getAllBooks(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<Book> books = bookService.getAllBooks(pageNum, pageSize);
        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(new Result(true, "Success", (Admin) books));
        } else {
            return ResponseEntity.ok(new Result(false, "No books found", (Admin) null));
        }
    }

    @GetMapping("/books/{id}")
    @ApiOperation(value = "根据ID获取书籍")
    public Result getBookById(@PathVariable int id) {
        Book book = adminService.getBookById(id);
        if (book != null) {
            return new Result(true, book);
        } else {
            return new Result(false, "Book not found");
        }
    }

    @PostMapping("/books/save")
    @ApiOperation(value = "添加书籍")
    public Result addBook(@RequestBody Book book) {
        try {
            adminService.saveBook(book);
            return new Result(true, "Book added successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to add book");
        }
    }

    @PostMapping("/books/update")
    @ApiOperation(value = "修改书籍信息")
    public Result updateBook(@RequestBody Book book) {
        try {
            adminService.updateBook(book);
            return new Result(true, "Book updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update book");
        }
    }

    @DeleteMapping("/books/delete/{bookId}")
    @ApiOperation(value = "删除书籍")
    public Result deleteBook(@PathVariable int bookId) {
        try {
            adminService.deleteBook(bookId);
            return new Result(true, "Book deleted successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to delete book");
        }
    }

    @GetMapping("/user/{userId}")
    @ApiOperation(value = "根据ID获取用户")
    public Result getUserById(@PathVariable int userId) {
        User user = adminService.getUserById(userId);
        if (user != null) {
            return new Result(true, user);
        } else {
            return new Result(false, "User not found");
        }
    }

    @GetMapping("/users")
    @ApiOperation(value = "获取所有用户")
    public Result getAllUsers() {
        List<User> users = adminService.getAllUsers();
        if (users != null) {
            return new Result(true, users);
        } else {
            return new Result(false, "Failed to get all users");
        }
    }

    @PostMapping("/user/update")
    @ApiOperation(value = "修改用户信息")
    public Result updateUser(@RequestBody User user) {
        try {
            adminService.updateUser(user);
            return new Result(true, "User updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update user");
        }
    }

    @GetMapping("/user/{userId}/borrowed")
    @ApiOperation(value = "获取已借阅的书籍")
    public Result getBorrowedBooks(@PathVariable int userId) {
        List<BorrowInfo> borrowedBooks = adminService.getBorrowedBooks(userId);
        if (borrowedBooks != null) {
            return new Result(true, borrowedBooks);
        } else {
            return new Result(false, "Failed to get borrowed books");
        }
    }

    @GetMapping("/user/{userId}/unreturned")
    @ApiOperation(value = "获取用户未归还的书籍")
    public Result getUnreturnedBooks(@PathVariable int userId) {
        List<BorrowInfo> unreturnedBooks = adminService.getUnreturnedBooks(userId);
        if (unreturnedBooks != null) {
            return new Result(true, unreturnedBooks);
        } else {
            return new Result(false, "Failed to get unreturned books");
        }
    }

    @PostMapping("/admin/updatePassword")
    @ApiOperation(value = "修改管理员密码")
    public Result updateAdminPassword(@RequestParam String username, @RequestParam String newPassword) {
        try {
            adminService.updateAdminPassword(username, newPassword);
            return new Result(true, "Admin password updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update admin password");
        }
    }

    @PostMapping("/admin/update")
    @ApiOperation(value = "修改管理员信息")
    public Result updateAdmin(@RequestBody Admin admin) {
        try {
            adminService.updateAdmin(admin);
            return new Result(true, "Admin updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update admin");
        }
    }
}