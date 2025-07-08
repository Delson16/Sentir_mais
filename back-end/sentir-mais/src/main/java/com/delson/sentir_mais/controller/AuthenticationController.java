package com.delson.sentir_mais.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    
    @GetMapping("/ola")
    public String ola(){
        return "Olá mundo";
    }
    
    
}
