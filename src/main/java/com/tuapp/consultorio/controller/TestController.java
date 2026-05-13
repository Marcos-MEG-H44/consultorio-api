package com.tuapp.consultorio.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String hola() {
        return "FUNCIONA";
    }
}