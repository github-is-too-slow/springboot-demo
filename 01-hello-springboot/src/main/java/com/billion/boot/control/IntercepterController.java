package com.billion.boot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Billion
 * @create 2021/03/23 22:53
 */
@Controller
public class IntercepterController {
    @GetMapping(value = {"/", "/login"})
    public String login(){
        return "login";
    }

    @GetMapping(value = "/main.html")
    public String main(){
        return "main";
    }
}
