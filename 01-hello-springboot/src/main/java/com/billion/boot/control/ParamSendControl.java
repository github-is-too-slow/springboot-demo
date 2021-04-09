package com.billion.boot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Billion
 * @create 2021/03/21 22:41
 */
@Controller
public class ParamSendControl implements WebMvcConfigurer{
    @ResponseBody
    @GetMapping("/car/{id}/owner/{uname}")
    public Map getParams(@PathVariable("id") Integer id,
                         @PathVariable("uname") String uname,
                         @RequestHeader("User-Agent") String userAgent,
                         @RequestHeader Map<String, String> headers,
//                         @RequestParam("pwd") String pwd,
//                         @RequestParam("hobbies") List<String> hobbies,
//                         @RequestAttribute("msg") String msg,
//                         @MatrixVariable(value = "one", pathVar = "id") String oneId,
//                         @MatrixVariable("two") Integer two,
                         @MatrixVariable(value = "one", pathVar = "uname") String oneUname){
        Map<String, Object> map = new HashMap<>();
        System.out.println("/car/id/uname");
        map.put("id", id);
        map.put("uname", uname);
//        map.put("oneId", oneId);
//        map.put("two", two);
//        map.put("oneUname", oneUname);
//        map.put("userAgent", userAgent);
//        map.put("headers", headers);
//        map.put("pwd", pwd);
//        map.put("hobbies", hobbies);

        return map;
    }

    @ResponseBody
    @GetMapping("/user/{id}/common/{uname}")
    public Map getParam(@PathVariable("id") Integer id,
                        @PathVariable("uname") String uname,
                        @MatrixVariable(value = "one", pathVar = "id") Integer oneId,
                        @MatrixVariable(value = "one", pathVar = "uname") String oneUname,
                        @MatrixVariable("hobbies") List<String> hobbies,
                        @MatrixVariable Map<String, Object> params){
        Map<String, Object> map = new HashMap<>();
        System.out.println("common user");
        map.put("id", id);
        map.put("uname", uname);
        map.put("oneId", oneId);
        map.put("oneUname", oneUname);
        map.put("two", hobbies);
        map.put("params", params);
        return map;
    }

    @ResponseBody
    @PostMapping("/loginxxx")
    public Map PostParams(@RequestBody String body){
        Map<String, Object> map = new HashMap<>();
        map.put("body", body);
        return map;
    }

    @RequestMapping("/hello")
    public String getRequestAttr(HttpServletRequest request){
        request.setAttribute("msg", "Hello world");
        request.setAttribute("code", 200);
        System.out.println("hello");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map getSuccess(@RequestAttribute("msg") String msg,
                          @RequestAttribute("code") Integer code,
                          HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        System.out.println("success");
        return map;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}
