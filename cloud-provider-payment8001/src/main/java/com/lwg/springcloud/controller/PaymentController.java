package com.lwg.springcloud.controller;

import com.lwg.springcloud.pojo.CommonResult;
import com.lwg.springcloud.pojo.Payment;
import com.lwg.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("插入结果为：....." + result);
        if (result > 0) {
            return new CommonResult(200, "数据插入成功", result);
        } else {
            return new CommonResult(444, "插入数据失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果为:.." + payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"查询结果为空,查询ID:"+id,null);
        }
    }
}
