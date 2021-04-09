package com.billion.boot.mapper;

import com.billion.boot.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Billion
 * @create 2021/03/24 23:46
 */
@Mapper
public interface BookMapper {
    public List<Book> queryBooks();

    @Insert("insert into spring_book(name,author) values(#{name},#{author})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertBook(Book book);
}
