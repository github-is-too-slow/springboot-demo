package com.billion.boot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Billion
 * @create 2021/03/24 22:16
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book {
    private Integer id;
    private String name;
    private String author;
}
