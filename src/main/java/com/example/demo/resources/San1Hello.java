package com.example.demo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class San1Hello {
    @GetMapping("/sanhello")
    public String sayHello(){
        return "san hello";
    }
}
