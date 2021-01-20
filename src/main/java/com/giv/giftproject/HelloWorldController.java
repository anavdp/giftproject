package com.giv.giftproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloWorldController {
    @GetMapping(value="/")
    public String helloWorld() {
        return "helloWorld";
    }
}