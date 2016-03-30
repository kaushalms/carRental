package com.code.kaushal.turorentalapp;

/**
 * Created by Kaushal on 3/29/2016.
 */
public class ErrorHandler {
    private String code;
    private String message;

    public ErrorHandler() {}

    public ErrorHandler(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorHandler{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
