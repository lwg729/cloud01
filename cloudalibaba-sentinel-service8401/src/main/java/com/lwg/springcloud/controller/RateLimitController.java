package com.lwg.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lwg.springcloud.myHandle.CustomerBlockHandler;
import com.lwg.springcloud.pojo.CommonResult;
import com.lwg.springcloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "bySource",blockHandler = "deal_Resource")
    public CommonResult bySource(){

        return new CommonResult(200,"按名称资源限流测试ok",new Payment(2020L,"serial1001"));
    }
    public CommonResult deal_Resource(BlockException exceptipon){
        return new CommonResult(444,exceptipon.getClass().getCanonicalName()+"服务不可以");
    }


    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按URL限流测试ok",new Payment(2020L,"serial1002"));
    }

    @GetMapping("/rateLimit/customerBlockException")
    @SentinelResource(value = "customerBlockException",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException")
    public CommonResult CustomerBlockHandler(){
        return new CommonResult(200,"按照客户自定义",new Payment(2020l,"serial1003"));
    }
}
