package com.lwg.springcloud.controller;

import com.lwg.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
/*@DefaultProperties(defaultFallback = "paymentInfo_globalHandler")*/
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = orderHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
/*   @HystrixCommand*/
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = orderHystrixService.paymentInfo_Timeout(id);
        return result;
    }
    /*public String paymentInfo_TimeoutHandler(@PathVariable("id") Integer id) {
        return "我是消费者80,支付系统繁忙,请稍后重试";
    }*/
   /* public String paymentInfo_globalHandler(){
       return "全局的服务降级方法";
    }*/
}
