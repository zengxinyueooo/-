package com.zxy.library_manager_system.controller;

import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.service.IBookService;
import com.zxy.library_manager_system.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController 注解标识该类是一个RESTful风格的控制器，
@RequestMapping(value = "/books") 指定了该控制器处理的请求路径为"/books"*/

@RestController
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    //save 新增
    @PostMapping
    public Result save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new Result(flag, flag?"添加成功":"添加失败");
    }

    //removeById 按序号删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return new Result(bookService.removeById(id));
    }

    //updateById 按序号修改
    @PutMapping
    public Result update(@RequestBody Book book){
        return new Result(bookService.updateById(book));
    }

    //getById 获取的时候要先判断有没有了
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return new Result(true, bookService.getById(id));
    }

    //list 获取全部 要判断
    @GetMapping
    public Result getAll(){
        return new Result(true, bookService.list());
    }
}
