package com.lwg.springcloud.service;

import com.lwg.springcloud.pojo.CommonResult;
import com.lwg.springcloud.pojo.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService implements PaymentService{
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(44444,
                "服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }

}
