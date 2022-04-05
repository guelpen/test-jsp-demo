package com.example.test_jsp_demo.controller;


import com.example.test_jsp_demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/register")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register_form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        System.out.println(user);
        System.out.print("register");
        System.out.print("new change");
        return "register_success";
    }
}
