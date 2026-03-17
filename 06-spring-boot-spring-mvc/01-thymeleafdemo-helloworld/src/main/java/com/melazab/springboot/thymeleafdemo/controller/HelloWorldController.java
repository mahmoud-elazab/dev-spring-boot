package com.melazab.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    // a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    // a controller method to process the HTML form

    @RequestMapping("/processForm")
    public  String processForm(){
        return "helloworld";
    }

    // a controller method to read form data
    // add data to the model

    @RequestMapping("/processFormv2")
    public String shout(HttpServletRequest request, Model model){

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all UpperCase
        theName = theName.toUpperCase();

        // create the message
        String result = "HEY " + theName + "!!";

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
