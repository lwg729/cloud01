package com.lwg.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class OrderHystrixServiceImpl implements OrderHystrixService{


    public String paymentInfo_OK(Integer id) {
        return "paymentfallback-------------paymentInfo_OK";
    }

    public String paymentInfo_Timeout(Integer id) {
        return "paymentfallback-------------paymentInfo_Timeout";
    }
}
