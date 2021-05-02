package com.treloc.sesizari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value="/")
    public String hello(){
        return "hello!";
    }
}