package com.shuoyi.feign.controller;

import com.shuoyi.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaosy-c on 2019/7/15.
 */
@RestController
@RequestMapping("/api/feign-consumer")
public class ConsumerController {

    @Autowired
    HelloService helloService;


    @GetMapping("feign-consumer")
    public String helloConsumer(){
        return helloService.hello();
    }
}
