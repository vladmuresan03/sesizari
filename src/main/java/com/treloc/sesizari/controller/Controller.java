package com.treloc.sesizari.controller;

import com.treloc.sesizari.api.PrimarieApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value="/")
    public String hello() {
        PrimarieApi primarieApi = new PrimarieApi();
        return "hello!" + primarieApi.get().size();
    }
}