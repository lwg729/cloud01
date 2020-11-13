package com.lwg.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "----------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info("*************:"+Thread.currentThread().getName()+"\t");
        return "----------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_HotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){


        return "-------------testHotKey";
    }

    public String deal_HotKey(String p1, String p2, BlockException exception){
        return "deal hotKey,o(╥﹏╥)o";
    }

}
