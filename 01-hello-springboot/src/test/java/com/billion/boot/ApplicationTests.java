package com.billion.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 测试数据源
	 */
	@Test
	void contextLoads() {
		String sql = "select * from spring_book";
		List<Book> books = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
		System.out.println("books = " + books);
	}

}
