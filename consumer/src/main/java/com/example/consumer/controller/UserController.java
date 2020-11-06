package com.example.consumer.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.consumer.Exception.HanlderExpection;
import com.example.consumer.feign.ConsumerFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiaoh
 * @create 2020/11/4 10:44
 */
@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private ConsumerFeign consumerFeign;

    /**
     * QPS单纯的代表每秒的访问次数，只要访问次数到达一定的阈值，这进行限流操作
     * 线程数，代表的是每秒内访问改api接口的线程数，如果该接口的操作比较长，当排队的线程数到达阈值的时候，进行限流操作，相反的如果接口的操作很快，即是没秒内的操作很快，同样不会进行限流操作
     * QPS可以简单的理解为访问次数，但是线程数是和接口处理的快慢有关的。
     *
     * blockHandler 管理sentinel的控制台设置的流控规则
     * blockHandler写在其他类时， 方法需要加上static 否则无法解析
     *
     * fallback 管理 java运行异常
     *
     */
    @SentinelResource(value = "hello", blockHandler = "helloHandleException", blockHandlerClass = {HanlderExpection.class}, fallback = "helloFallback")
    @RequestMapping("/hello")
    public String hello(@RequestParam String id) {


        if("0".equals(id)){
            throw new RuntimeException(" 出异常了 !!!");
        }

        System.out.println(id);
        return consumerFeign.hello(id);
    }

    @SentinelResource(value = "test", blockHandler = "testHandleException", blockHandlerClass = {HanlderExpection.class}, fallback = "testFallback")
    @RequestMapping("/test")
    public String testDemo(){

        return consumerFeign.test();
    }

    public String helloFallback(@RequestParam String id){

        System.out.println("msg: helloFallback");
        return "msg: helloFallback ";
    }

    public String testFallback(){

        System.out.println("msg: testFallback");
        return "msg: testFallback ";
    }

}

