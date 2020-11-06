package com.example.producer.service.Impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.producer.mapper.UserMapper;
import com.example.producer.pojo.User;
import com.example.producer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xiaoh
 * @create 2020/11/4 11:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 链路模式 API级别的流控 测试未成功
     * @return
     */
    @Override
    @SentinelResource(value = "testService", blockHandler = "testHandleException")
    public String testService() {

        return "nacos test";
    }


    @Override
    public List<User> userAllService() {
        return userMapper.userAll();
    }


    public String testHandleException(){

        return "testHandleException";
    }
}

