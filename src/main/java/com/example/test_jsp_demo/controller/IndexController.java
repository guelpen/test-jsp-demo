package com.example.test_jsp_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(value ="name", defaultValue = "World",
                required = true) String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }

    @GetMapping("/hi-hello")
    public String hiHello(){
        return "hi-hello";
    }

}
