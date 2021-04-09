package com.billion.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.billion.boot.entity.User;
import com.billion.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Billion
 * @create 2021/03/25 14:13
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/showUsers")
    public String showUsers(Model model,
                            @RequestParam(value = "pn", defaultValue = "1") Integer pn){
//        //获取用户数据
//        List<User> users = userService.list();
//        model.addAttribute("users", users);
//        return "show";
        //封装请求页数和每页记录数
        Page<User> page1 = new Page<>(pn, 5);
        //获取分页用户数据
        Page<User> page2 = userService.page(page1, null);
        model.addAttribute("page", page2);
        return "show";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id,
                                 @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                 RedirectAttributes ra){
        //删除用户
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/showUsers";
    }
}
