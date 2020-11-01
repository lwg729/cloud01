package com.lwg.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
/*@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //找到这个微服务中的方法*/
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = OrderHystrixServiceImpl.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);

}
