package com.example.TierListApi.exception;

public class NotFoundByIdException extends RuntimeException{
    public NotFoundByIdException(String message) {
        super(message);
    }
}
