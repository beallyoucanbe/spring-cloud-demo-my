package com.shuoyi.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhaosy-c on 2019/7/15.
 */

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/api/hello-service/hello")
    String hello();
}
