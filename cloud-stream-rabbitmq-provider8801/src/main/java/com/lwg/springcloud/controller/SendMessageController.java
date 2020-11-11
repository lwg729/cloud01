package com.lwg.springcloud.controller;


import com.lwg.springcloud.service.ImessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private ImessageProvider imessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return imessageProvider.send();
    }
}
