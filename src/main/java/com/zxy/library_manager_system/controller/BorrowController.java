package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.service.IBorrowService;
import com.zxy.library_manager_system.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;

    @PostMapping("/borrowBook")
    public Result borrowBook(@RequestParam int bookId, @RequestParam int userId) {
        borrowService.borrowBook(bookId, userId);
        return new Result(true, "Book borrowed successfully.");
    }

    @PostMapping("/returnBook")
    public Result returnBook(@RequestParam int bookId, @RequestParam int userId, @RequestParam Date returnDate) {
        borrowService.returnBook(bookId, userId, returnDate);
        return new Result(true, "Book returned successfully.");
    }

    @GetMapping("/getBorrowInfo")
    public Result getBorrowInfoByUserId(@RequestParam int userId) {
        List<BorrowInfo> borrowInfoList = borrowService.getBorrowInfoByUserId(userId);
        return new Result(true, borrowInfoList);
    }
}