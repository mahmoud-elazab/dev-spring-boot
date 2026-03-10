package com.firstapp.springboot.firstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class FunRestController {
    // expose "/" that return "Hello World"

    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hello World!";
    }

}
