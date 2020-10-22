package com.lwg.springcloud.mapper;

import com.lwg.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    public int save(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
