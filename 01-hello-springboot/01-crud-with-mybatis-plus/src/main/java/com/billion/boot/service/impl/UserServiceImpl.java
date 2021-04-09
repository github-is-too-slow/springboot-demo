package com.billion.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.billion.boot.entity.User;
import com.billion.boot.mapper.UserMapper;
import com.billion.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Billion
 * @create 2021/03/25 14:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
