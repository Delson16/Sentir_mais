package com.delson.sentir_mais.service;


import com.delson.sentir_mais.domain.User;
import com.delson.sentir_mais.dto.UserLoginDto;
import com.delson.sentir_mais.dto.UserLoginResponseDto;
import com.delson.sentir_mais.dto.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService{

    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    TokenService tokenService;

    public UserLoginResponseDto login(UserLoginDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        User user = (User) auth.getPrincipal();
        String token = tokenService.generateToken(user);
        return new UserLoginResponseDto(user.getName(), token);
    }
    
    public UserLoginResponseDto login(UserRegisterDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        User user = (User) auth.getPrincipal();
        String token = tokenService.generateToken(user);
        return new UserLoginResponseDto(user.getName(), token);
    }

}
