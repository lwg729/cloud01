package com.lwg.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.lwg.springcloud.service.ImessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


@EnableBinding(Source.class)  //定义消息的推送管道
public class ImessageProviderImpl implements ImessageProvider {

    @Autowired
    private MessageChannel output;  //消息发送管理

    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial: "+serial);
        return null;
    }
}
