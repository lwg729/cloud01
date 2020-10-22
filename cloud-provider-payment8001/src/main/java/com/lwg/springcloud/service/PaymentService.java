package com.lwg.springcloud.service;

import com.lwg.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int save(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
