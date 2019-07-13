package com.shuoyi.controller;

import com.shuoyi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaosy-c on 2018/9/5.
 */

@RestController
@RequestMapping("/api/ribbon-consumer")
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return helloService.helloService();
    }
}
