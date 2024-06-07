
package com.example.practica.demo.service;

import com.example.practica.demo.dto.ConsumeIdAndStringDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ApiWebService {

    public List<ConsumeIdAndStringDto> getListaApi(String response);
    
}
