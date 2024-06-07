package com.example.practica.demo.exception;

public class RequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String status;
    
    private int code;

    public RequestException(String status, String message, int code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}