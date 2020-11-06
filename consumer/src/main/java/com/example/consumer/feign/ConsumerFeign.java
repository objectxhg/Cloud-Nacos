package com.example.consumer.feign;


import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 调用服务提供者
 */
@FeignClient("producer-service")
public interface ConsumerFeign {

    @RequestMapping("/producer/hello")
    String hello(@RequestParam String id);


    @RequestMapping("/producer/test")
    String test();
}

