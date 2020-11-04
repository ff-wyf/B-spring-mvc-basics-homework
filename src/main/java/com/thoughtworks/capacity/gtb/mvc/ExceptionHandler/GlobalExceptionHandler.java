package com.thoughtworks.capacity.gtb.mvc.ExceptionHandler;

import com.thoughtworks.capacity.gtb.mvc.Error.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNameIsSameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.HTML;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> errorHandler(MethodArgumentNotValidException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(UserNameIsSameException.class)
    public ResponseEntity<ErrorResult> errorHandler(UserNameIsSameException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
