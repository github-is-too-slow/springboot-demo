package com.billion.boot.mapperplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.billion.boot.Book;

/**
 * 继承BaseMapper<Book>自动拥有对Book的增删改查功能
 * @author Billion
 * @create 2021/03/25 11:06
 */
public interface BookMapper2 extends BaseMapper<Book> {
}
