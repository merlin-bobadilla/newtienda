
package com.example.practica.demo.exception;

import java.util.Date;


public class ResponseStatusStringDto {
    private Date timestamp;
    private String status;
    private String message;
    private Integer code;
    private String stringObject;

    public ResponseStatusStringDto( String status, Integer code,String message, String stringObject) {
        this.setTimestamp(new Date());
        this.status = status;
        this.message = message;
        this.code = code;
        this.stringObject = stringObject;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    private void setTimestamp(Date timestamp) {
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

    public String getStringObject() {
        return stringObject;
    }

    public void setStringObject(String stringObject) {
        this.stringObject = stringObject;
    }

    @Override
    public String toString() {
        return "ResponseStatusStringDto{" + "timestamp=" + timestamp + ", status=" + status + ", message=" + message + ", code=" + code + ", stringObject=" + stringObject + '}';
    }
    
    
}
