package com.delson.sentir_mais.exception;

public class LoginAlreadyExistsException extends RuntimeException {
    
    public LoginAlreadyExistsException(){super ("O e-mail informado ja está em uso.");}
    
    public LoginAlreadyExistsException(String message){super (message);};
    
}
