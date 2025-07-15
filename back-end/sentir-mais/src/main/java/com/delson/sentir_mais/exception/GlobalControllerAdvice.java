package com.delson.sentir_mais.exception;


import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> genericException(Exception e) {
        var body = new ErrorMessage("Erro Inesperado: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<Object> jwtCreationException() {
        var body = new ErrorMessage("Erro ao criar o token se segurança", HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(LoginAlreadyExistsException.class)
    public ResponseEntity<Object> loginAlreadyExistsException(LoginAlreadyExistsException e) {
        var body = new ErrorMessage(e.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity badCredentialsException(){
        var body = new ErrorMessage("Login ou senha inválidos", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    
    @ExceptionHandler(EmotionNotFoundException.class)
    public ResponseEntity emotionNotFoundException(EmotionNotFoundException e){
        var body = new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFoundException(UserNotFoundException e){
        var body = new ErrorMessage(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}
