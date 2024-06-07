
package com.example.practica.demo.exception;

import com.example.practica.demo.dto.PersonaDto;
import java.util.Date;


public class ResponseStatusDeleteDto {
    private Date timestamp;
    private String status;
    private String message;
    private Integer code;
    private PersonaDto personaDto;

    public ResponseStatusDeleteDto(String status, Integer code, String message, PersonaDto personaDto) {
        this.setTimestamp(new Date());
        this.status = status;
        this.message = message;
        this.code = code;
        this.personaDto = personaDto;
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

    public PersonaDto getPersonaDto() {
        return personaDto;
    }

    public void setPersonaDto(PersonaDto personaDto) {
        this.personaDto = personaDto;
    }

    @Override
    public String toString() {
        return "ResponseStatusDeleteDto{" + "timestamp=" + timestamp + ", status=" + status + ", message=" + message + ", code=" + code + ", personaDto=" + personaDto + '}';
    }
    
    
}
