package com.billion.boot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Billion
 * @create 2021/03/25 14:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@TableName("t_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
}
