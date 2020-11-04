package com.thoughtworks.capacity.gtb.mvc.ExceptionHandler;

import com.thoughtworks.capacity.gtb.mvc.Error.ErrorResult;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNameIsSameException;
import com.thoughtworks.capacity.gtb.mvc.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> errorHandler(MethodArgumentNotValidException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getBindingResult().getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(UserNameIsSameException.class)
    public ResponseEntity<ErrorResult> errorHandler(UserNameIsSameException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResult> errorHandler(UserNotFoundException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.badRequest().body(errorResult);
    }
}
