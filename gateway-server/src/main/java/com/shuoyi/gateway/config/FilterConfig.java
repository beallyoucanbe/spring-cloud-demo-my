package com.shuoyi.gateway.config;

import com.shuoyi.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhaosy-c on 2019/7/13.
 */
@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
