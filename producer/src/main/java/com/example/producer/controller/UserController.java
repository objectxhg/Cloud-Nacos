package com.example.producer.controller;


import com.example.producer.pojo.User;
import com.example.producer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xiaoh
 * @create 2020/11/4 11:26
 */

@RestController
@RequestMapping("/producer")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(@RequestParam String id){
        System.out.println(id);
        return "hello nacos, id: " + id;
    }

    @RequestMapping("/test")
    public String testController(){

        return userService.testService();
    }

    @RequestMapping("/userAll")
    public List<User> userAll(){

        return userService.userAllService();
    }

}

