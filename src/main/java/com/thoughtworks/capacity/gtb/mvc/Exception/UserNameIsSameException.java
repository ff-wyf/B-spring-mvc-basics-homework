package com.thoughtworks.capacity.gtb.mvc.Exception;

public class UserNameIsSameException extends RuntimeException {
    public UserNameIsSameException(String message) {
        super(message);
    }
}
