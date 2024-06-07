
package com.example.practica.demo.controller;

import com.example.practica.demo.dto.ConsumeIdAndStringDto;
import com.example.practica.demo.exception.RequestException;
import com.example.practica.demo.service.ApiWebService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")//es el acceso para consumir aplicaciones desde cualquier lado del cliente(angular,php,pyton,,cualquier servicio rest)
@RequestMapping("/peticionesapi")
@RestController
public class ConsumeApisController {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ApiWebService apiWebService;
    
    @GetMapping(value = "/cosumEApiWeb", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConsumeIdAndStringDto>> getConsumeApiweb() {
        String response=this.restTemplate.getForObject("https://cat-fact.herokuapp.com/facts", String.class);
        
        List<ConsumeIdAndStringDto>consumeIdAndStringDto=this.apiWebService.getListaApi(response);
        
        


        return new ResponseEntity<>(consumeIdAndStringDto, HttpStatus.OK);
        




    }
    
}
