package com.billion.boot.control;

import com.billion.boot.Book;
import com.billion.boot.mapperplus.BookMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Billion
 * @create 2021/03/25 11:10
 */
@Controller
public class MybatisPlusController {
    @Autowired
    private BookMapper2 bookMapper2;

    @ResponseBody
    @GetMapping("/findBook")
    public Book getBooks(){
        Book book = bookMapper2.selectById(1);
        return book;
    }

}
