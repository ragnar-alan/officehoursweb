package com.epam.exception;

/**
 * Created by Tamas_Boros on 6/8/2017.
 */

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
