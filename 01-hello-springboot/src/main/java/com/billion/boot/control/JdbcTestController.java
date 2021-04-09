package com.billion.boot.control;

import com.billion.boot.Book;
import com.billion.boot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Billion
 * @create 2021/03/24 22:56
 */
@Controller
public class JdbcTestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BookMapper bookMapper;

    @ResponseBody
    @GetMapping("/book")
    public void getBooks(){
        String sql = "select * from spring_book";
        List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        System.out.println("books = " + books);
    }

    @ResponseBody
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        List<Book> books = bookMapper.queryBooks();
        System.out.println("books = " + books);
        return books;
    }

    @ResponseBody
    @GetMapping("/insert")
    public Book insertBook(Book book){
        bookMapper.insertBook(book);
        return book;
    }
}
