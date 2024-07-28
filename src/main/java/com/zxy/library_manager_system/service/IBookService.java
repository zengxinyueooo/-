package com.zxy.library_manager_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.library_manager_system.domain.Book;
import com.zxy.library_manager_system.domain.Result;

import java.util.List;

/**
 * @author zxy
 */
//泛型参数<Book> 表示该接口操作的实体类是Book，即该接口定义了对Book实体类的业务操作方法。
//通过@Service 注解标注的类会被Spring容器自动扫描并管理，可以通过依赖注入的方式在其他组件中使用该服务类。

public interface IBookService extends IService<Book>{

    void decreaseBookQuantity(int bookId);

    void increaseBookQuantity(int bookId);

    List<Book> getAllBooks(int pageNum, int pageSize);

}
