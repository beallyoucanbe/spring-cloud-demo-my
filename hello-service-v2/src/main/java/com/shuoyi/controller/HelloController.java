package com.shuoyi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhaosy-c on 2018/9/3.
 */
@RestController
@RequestMapping("/api/hello-service")
public class HelloController {

    @Value("${common.db.db_gccs_storage.url}")
    private String testName;

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @GetMapping("test_name")
    public String getName(){
        return testName;
    }

    @GetMapping("/hello")
    public String index(){
        List<String> serviceNames = client.getServices();
        for(String service : serviceNames){
            logger.info("/hello, " + service);
        }
        return "Hello World";
    }

    @GetMapping("/get_instance")
    public String getInstance(@RequestParam String name){
        List<ServiceInstance> instances = client.getInstances(name);
        for(ServiceInstance instance : instances){
            Map<String, String> metaData = instance.getMetadata();
            for(Map.Entry<String, String> entry : metaData.entrySet()){
                logger.info(entry.getKey() + ", " + entry.getValue());
            }
        }
        return "Hello World";
    }

}
