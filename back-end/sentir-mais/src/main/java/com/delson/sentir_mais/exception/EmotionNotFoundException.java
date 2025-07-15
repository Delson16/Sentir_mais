package com.delson.sentir_mais.exception;

public class EmotionNotFoundException extends RuntimeException{
    
    public EmotionNotFoundException(){
        super("Emoção não encontrada");
    };
    
    public EmotionNotFoundException(String message){
        super(message);
    }
    
}
