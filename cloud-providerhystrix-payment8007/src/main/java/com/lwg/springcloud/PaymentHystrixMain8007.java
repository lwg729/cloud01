package com.lwg.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8007 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentHystrixMain8007.class,args);
    }
}
