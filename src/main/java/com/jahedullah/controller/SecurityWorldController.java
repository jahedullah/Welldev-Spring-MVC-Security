package com.jahedullah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityWorldController {

    @ResponseBody
    @GetMapping("/")
    public String init(){
        return "Security issues";
    }

    @GetMapping("/securityWorld")
    public String securityWorld(){

        return "security-world";
    }

}
