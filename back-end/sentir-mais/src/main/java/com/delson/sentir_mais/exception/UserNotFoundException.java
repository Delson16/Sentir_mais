package com.delson.sentir_mais.exception;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(){
        super("Usuário não enontrado");
    }
    
    public UserNotFoundException(String message){
        super(message); 
    }
    
}
