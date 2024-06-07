package com.example.practica.demo.exception;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerAdvice {

    @Value("${error.json.null}")
    private String jsonNull;

    @Value("${error.method}")
    private String methodIncomplete;

    @Value("${error.read.method}")
    private String errorReadMethod;
    
    @Value("${error.insert.values}")
    private String errorValues;

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ResponseStatusDTO> error(RequestException ex) {
        ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO(ex.getStatus(), ex.getMessage(), ex.getCode());
        return ResponseEntity.status(ex.getCode()).body(responseStatusDTO);
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ResponseStatusDTO> error(HttpMediaTypeNotSupportedException ex) {
        ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO(HttpStatus.BAD_REQUEST.name(), jsonNull, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseStatusDTO);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseStatusDTO> error(HttpMessageNotReadableException ex) {
        ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO(HttpStatus.BAD_REQUEST.name(), errorReadMethod, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseStatusDTO);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseStatusDTO> error(HttpRequestMethodNotSupportedException ex) {
        ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO(HttpStatus.BAD_REQUEST.name(), methodIncomplete, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseStatusDTO);
    }
    
    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<ResponseStatusDTO> error(SQLException ex) {
        ResponseStatusDTO responseStatusDTO = new ResponseStatusDTO(HttpStatus.BAD_REQUEST.name(), errorValues, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseStatusDTO);
    }

}
