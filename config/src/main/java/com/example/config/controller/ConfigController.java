package com.example.config.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiaoh
 * @create 2020/11/3 11:29
 */

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${user.userName}")
    private String userName;

    @Value("${user.age}")
    private int age;

    @RequestMapping("/user")
    public String getUser() {
        return "Hello " + userName + " " + age + "!";
    }

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}

