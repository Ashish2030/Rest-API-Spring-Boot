package com.example.demo.Exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message)
    {
        super(message);
    }
}
