package com.sample.app.exception;

public class CustomMsgException extends Exception {
    
    public CustomMsgException(String msg, Throwable err) {
        super(msg, err);
    }
}
