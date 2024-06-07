package com.example.practica.demo.exception;

import java.util.Date;

public class ResponseStatusDTO {

    private Date timestamp;
    private String status;
    private String message;
    private Integer code;

    public ResponseStatusDTO(String status, String message, int code) {
        setTimestamp(new Date());
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public final void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
