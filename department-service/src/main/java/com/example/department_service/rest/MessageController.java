package com.example.department_service.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    @Value("${spring.nguyenhang}")
    private String message;

    @GetMapping("getMessage")
    public String getMessages(){
        return message;
    }
}
