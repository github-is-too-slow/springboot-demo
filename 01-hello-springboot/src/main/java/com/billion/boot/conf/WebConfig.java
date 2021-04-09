package com.billion.boot.conf;

import com.billion.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Billion
 * @create 2021/03/23 23:11
 */
@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")//拦截所有动态和静态请求
                        .excludePathPatterns("/", "/login", "/css/**", "/js/**");
            }
        };
    }
}
