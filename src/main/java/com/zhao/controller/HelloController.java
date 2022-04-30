package com.zhao.controller;

import com.zhao.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhaomo
 * @Date: 2020/03/30 20:56
 * @Description:
 */

@ApiOperation("Hello控制类")
@RestController
public class HelloController {

    @GetMapping (value = "/hello")
    public String hello(){

        return "hello";
    }

    //只要我们的接口中,返回值中存在实体类,它就会被扫描到Swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }



}
