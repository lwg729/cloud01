package com.lwg.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope      //支持nacos的动态刷新功能,保证nacos.config的实时更新
public class NacosClientMain3377 {


    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
