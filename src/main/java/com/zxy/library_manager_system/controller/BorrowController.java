package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.BorrowInfo;
import com.zxy.library_manager_system.service.IBorrowService;
import com.zxy.library_manager_system.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/borrow")
@Api(tags = "借阅信息管理")
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;

    @PostMapping("/borrowBook")
    @ApiOperation(value = "借阅书籍")
    public Result borrowBook(@RequestParam int borrowId, @RequestParam int bookId, @RequestParam int userId) {
        Book borrowedBook = borrowService.borrowBook(borrowId, bookId, userId); // 假设borrowService.borrowBook方法返回借阅的书籍信息
        if (borrowedBook != null) {
            return new Result(true, "Book borrowed successfully.", borrowedBook);
        } else {
            return new Result(false, "Failed to borrow book. Please check the input parameters.");
        }
    }

    @PostMapping("/returnBook")
    @ApiOperation(value = "归还书籍")
    public Result returnBook(@RequestParam int borrowId, @RequestParam int bookId, @RequestParam int userId) {
        borrowService.returnBook(borrowId, bookId, userId);
        return new Result(true, "Book returned successfully.");
    }

    @GetMapping("/getBorrowInfo")
    @ApiOperation(value = "根据用户id查找借阅信息")
    public Result getBorrowInfoByUserId(@RequestParam int userId) {
        List<BorrowInfo> borrowInfoList = borrowService.getBorrowInfoByUserId(userId);
        return new Result(true, borrowInfoList);
    }
}