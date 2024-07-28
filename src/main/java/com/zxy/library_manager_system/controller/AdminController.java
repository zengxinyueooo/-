package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.*;
import com.zxy.library_manager_system.service.IAdminService;
import com.zxy.library_manager_system.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// AdminController.java
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IBookService bookService;

  /*  @GetMapping("/books")
    public Result getAllBooks() {
        List<Book> books = adminService.getAllBooks();
        if (books != null) {
            return new Result(true, books);
        } else {
            return new Result(false, "Failed to get all books");
        }
    }     无分页的   */

    @GetMapping("/books/all")
    public ResponseEntity<Result> getAllBooks(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<Book> books = bookService.getAllBooks(pageNum, pageSize);
        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(new Result(true, "Success", (Admin) books));
        } else {
            return ResponseEntity.ok(new Result(false, "No books found", (Admin) null));
        }
    }

    @GetMapping("/books/{id}")
    public Result getBookById(@PathVariable int id) {
        Book book = adminService.getBookById(id);
        if (book != null) {
            return new Result(true, book);
        } else {
            return new Result(false, "Book not found");
        }
    }

    @PostMapping("/books/save")
    public Result addBook(@RequestBody Book book) {
        try {
            adminService.saveBook(book);
            return new Result(true, "Book added successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to add book");
        }
    }

    @PostMapping("/books/update")
    public Result updateBook(@RequestBody Book book) {
        try {
            adminService.updateBook(book);
            return new Result(true, "Book updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update book");
        }
    }

    @DeleteMapping("/books/delete/{bookId}")
    public Result deleteBook(@PathVariable int bookId) {
        try {
            adminService.deleteBook(bookId);
            return new Result(true, "Book deleted successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to delete book");
        }
    }

    @GetMapping("/user/{userId}")
    public Result getUserById(@PathVariable int userId) {
        User user = adminService.getUserById(userId);
        if (user != null) {
            return new Result(true, user);
        } else {
            return new Result(false, "User not found");
        }
    }

    @GetMapping("/users")
    public Result getAllUsers() {
        List<User> users = adminService.getAllUsers();
        if (users != null) {
            return new Result(true, users);
        } else {
            return new Result(false, "Failed to get all users");
        }
    }

    @PostMapping("/user/update")
    public Result updateUser(@RequestBody User user) {
        try {
            adminService.updateUser(user);
            return new Result(true, "User updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update user");
        }
    }

    @GetMapping("/user/{userId}/borrowed")
    public Result getBorrowedBooks(@PathVariable int userId) {
        List<BorrowInfo> borrowedBooks = adminService.getBorrowedBooks(userId);
        if (borrowedBooks != null) {
            return new Result(true, borrowedBooks);
        } else {
            return new Result(false, "Failed to get borrowed books");
        }
    }

    @GetMapping("/user/{userId}/unreturned")
    public Result getUnreturnedBooks(@PathVariable int userId) {
        List<BorrowInfo> unreturnedBooks = adminService.getUnreturnedBooks(userId);
        if (unreturnedBooks != null) {
            return new Result(true, unreturnedBooks);
        } else {
            return new Result(false, "Failed to get unreturned books");
        }
    }

    @PostMapping("/admin/updatePassword")
    public Result updateAdminPassword(@RequestParam String username, @RequestParam String newPassword) {
        try {
            adminService.updateAdminPassword(username, newPassword);
            return new Result(true, "Admin password updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update admin password");
        }
    }

    @PostMapping("/admin/update")
    public Result updateAdmin(@RequestBody Admin admin) {
        try {
            adminService.updateAdmin(admin);
            return new Result(true, "Admin updated successfully");
        } catch (Exception e) {
            return new Result(false, "Failed to update admin");
        }
    }
}