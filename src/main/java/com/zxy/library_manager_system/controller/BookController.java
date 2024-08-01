package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.Admin;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.service.IBookService;
import com.zxy.library_manager_system.domain.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController 注解标识该类是一个RESTful风格的控制器，
@RequestMapping(value = "/books") 指定了该控制器处理的请求路径为"/books"*/

@RestController
@RequestMapping(value = "/books")
@Api(tags = "图书管理")
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation("新增图书")
    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功" : "添加失败");
    }

    @ApiOperation("按序号删除图书")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new Result(flag, flag ? "删除成功" : "删除失败");
    }

    @ApiOperation("修改图书信息")
    @PutMapping
    public Result update(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new Result(flag, flag ? "修改成功" : "修改失败");
    }

    @ApiOperation("根据ID获取图书信息")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Book book = bookService.getById(id);
        if (book != null) {
            return new Result(true, book);
        } else {
            return new Result(false, "Book not found");
        }
    }

    @ApiOperation("分页获取全部图书信息")
    @GetMapping("/all")
    public ResponseEntity<Result> getAllBooks(@RequestParam int pageNum, @RequestParam int pageSize) {
        List<Book> books = bookService.getAllBooks(pageNum, pageSize);
        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(new Result(true, "Success", (Admin) books));
        } else {
            return ResponseEntity.ok(new Result(false, "No books found", (Admin) null));
        }
    }

    @ApiOperation("减少图书数量")
    @PostMapping("/decreaseBookQuantity")
    public Result decreaseBookQuantity(@RequestParam int bookId) {
        bookService.decreaseBookQuantity(bookId);
        return new Result(true, "Book quantity decreased");
    }

    @ApiOperation("增加图书数量")
    @PostMapping("/increaseBookQuantity")
    public Result increaseBookQuantity(@RequestParam int bookId) {
        bookService.increaseBookQuantity(bookId);
        return new Result(true, "Book quantity increased");
    }
}