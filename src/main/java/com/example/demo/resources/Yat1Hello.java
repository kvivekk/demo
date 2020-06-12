package com.example.demo.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Yat1Hello {

    @GetMapping("/yathello")
    public String sayHello(){
        return "yatesh hello";
    }
}
