package com.lwg.springcloud.service.impl;

import com.lwg.springcloud.mapper.PaymentMapper;
import com.lwg.springcloud.pojo.Payment;
import com.lwg.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
