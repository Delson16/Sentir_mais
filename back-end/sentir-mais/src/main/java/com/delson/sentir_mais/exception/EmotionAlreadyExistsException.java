package com.delson.sentir_mais.exception;

public class EmotionAlreadyExistsException extends RuntimeException {

    public EmotionAlreadyExistsException(String message) {
        super(message);
    }
    
    public EmotionAlreadyExistsException(){
        super("Emoção ja cadastrada no sistema");
    }

}
