package com.melazab.springboot.demosecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    // add a request mapping for /managers
    @GetMapping("/managers")
    public String showManagers(){
        return "managers";
    }

    // add a request mapping for /systems
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }

}
