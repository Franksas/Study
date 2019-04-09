package com.dhcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by asus on 2019/3/11.
 */
@ResponseBody
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello World quick!";
    }

}