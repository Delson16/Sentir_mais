package com.delson.sentir_mais.controller;

import com.delson.sentir_mais.dto.UserLoginDto;
import com.delson.sentir_mais.dto.UserLoginResponseDto;
import com.delson.sentir_mais.dto.UserRegisterDto;
import com.delson.sentir_mais.service.AuthenticationService;
import com.delson.sentir_mais.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserService userService;
    
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity regitser(@Valid @RequestBody UserRegisterDto data) {
        userService.register(data);
        UserLoginResponseDto bodyContent = authenticationService.login(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(bodyContent);
    }
    
    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody UserLoginDto data){
        UserLoginResponseDto bodyContent = authenticationService.login(data);
        return ResponseEntity.ok(bodyContent);
    }
    

}
