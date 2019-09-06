package com.example.microservices.dao.exception;

public class UserDaoException extends RuntimeException {

    public UserDaoException(String message){
        super(message);
    }
}
