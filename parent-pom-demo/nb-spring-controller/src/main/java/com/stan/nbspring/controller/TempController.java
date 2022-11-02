package com.stan.nbspring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    @GetMapping("/")
    public String index(){
        return "temp-test";
    }
}
