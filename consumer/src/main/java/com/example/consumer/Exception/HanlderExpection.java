package com.example.consumer.Exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Author xiaoh
 * @create 2020/11/5 15:07
 */
public class HanlderExpection {

    /**
     * blockHandler写在其他类时， 方法需要加上static 否则无法解析
     */
    public static  String helloHandleException(String id, BlockException e){

        return "msg: hello 流控, Oops:" + e.getClass().getCanonicalName();
    }

    public static  String testHandleException(BlockException e){

        return "msg: test 流控，持久化配置规则, Oops:" + e.getClass().getCanonicalName();
    }

    public static  String degradeException(@RequestParam Integer id, BlockException e){

        return "msg: demo 降级, Oops:" + e.getClass().getCanonicalName();
    }


}

