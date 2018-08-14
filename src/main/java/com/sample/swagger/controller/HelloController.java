package com.sample.swagger.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@Api(description = "인사용 컨트롤러")
public class HelloController {

    @GetMapping
    public String doGet(){
        return "hello";
    }
    @PostMapping
    public String doPost(){
        return "hello World";
    }
}
