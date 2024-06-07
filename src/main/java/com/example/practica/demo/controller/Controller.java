package com.example.practica.demo.controller;

import com.example.practica.demo.dto.ActualizaPersonaDto;
import com.example.practica.demo.dto.ActualizaProductoDto;
import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.DobleIdDto;
import com.example.practica.demo.dto.InsertaPersonaDto;
import com.example.practica.demo.dto.InsertaProductoDto;
import com.example.practica.demo.dto.InsertaTiendaDto;
import com.example.practica.demo.dto.PersonaDto;
import com.example.practica.demo.dto.ValueLongDto;
import com.example.practica.demo.exception.RequestException;
import com.example.practica.demo.exception.ResponseStatusDeleteDto;
import com.example.practica.demo.exception.ResponseStatusStringDto;
import com.example.practica.demo.service.PersonaService;
import com.example.practica.demo.service.ProductoService;
import com.example.practica.demo.service.TiendaService;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")//es el acceso para consumir aplicaciones desde cualquier lado del cliente(angular,php,pyton,,cualquier servicio rest)
@RestController
public class Controller {


    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private TiendaService tiendaService ;

//    @PostMapping(value = "/insertaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ValueLongDto> insertPersona(@RequestBody InsertaPersonaDto insertaPersonaDto) {
//     if (insertaPersonaDto.getId() != 0) {
//            System.out.println("No se puede mandar un Id que sea diferente de 0");
//        } else {
//
//            ValueLongDto valueLongDto = this.personaService.insertaPersona(insertaPersonaDto);
//            return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
//        }  
//
//    }
    @PostMapping(value = "/insertaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValueLongDto> insertPersona(@RequestBody InsertaPersonaDto insertaPersonaDto) throws SQLException {

        ValueLongDto valueLongDto = this.personaService.insertaPersona(insertaPersonaDto);
        return new ResponseEntity<>(valueLongDto, HttpStatus.OK);

    }

    @PutMapping(value = "/actualizaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValueLongDto> updatePersona(@RequestBody ActualizaPersonaDto actualizaPersonaDto) {

        if (this.personaService.existPersona(actualizaPersonaDto.getId())) {
            ValueLongDto valueLongDto = this.personaService.actualizaPersona(actualizaPersonaDto);
            return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el Id del usuario", HttpStatus.NOT_FOUND.value());
        }

//        if (insertaPersonaDto.ged() != 0) {
//            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No se puede mandar un Id que sea diferente de 0", HttpStatus.NOT_FOUND.value());
//        } else {
//            System.out.println(insertaPersonaDto.getApellidos());
//            ValueLongDto valueLongDto = this.personaService.insertaPersona(insertaPersonaDto);
//            return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
//        }
//        if (insertaPersonaDto.ged() != 0) {
//            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No se puede mandar un Id que sea diferente de 0", HttpStatus.NOT_FOUND.value());
//        } else {
//            System.out.println(insertaPersonaDto.getApellidos());
//            ValueLongDto valueLongDto = this.personaService.insertaPersona(insertaPersonaDto);
//            return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
//        }
    }

    @DeleteMapping(value = "/eliminaPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumePorString> deletePersona(@RequestBody ValueLongDto valueLongDto) {

        if (this.personaService.existPersona(valueLongDto.getIdValueLongDto())) {
            ConsumePorString mensaje = this.personaService.eliminaPersona(valueLongDto);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el  usuario", HttpStatus.NOT_FOUND.value());
        }
    }

    @DeleteMapping(value = "/eliminaPersonaConDatos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStatusDeleteDto> eliminaPersona(@RequestBody ValueLongDto valueLongDto) {

        if (this.personaService.existPersona(valueLongDto.getIdValueLongDto())) {
            ResponseStatusDeleteDto responseStatusDeleteDto;
            PersonaDto personaDto;
            personaDto = this.personaService.eliminaPersonaDatos(valueLongDto);
            responseStatusDeleteDto = new ResponseStatusDeleteDto(HttpStatus.OK.name(), HttpStatus.OK.value(), "El usuario eliminado es: ", personaDto);

            return new ResponseEntity<>(responseStatusDeleteDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el  usuario", HttpStatus.NOT_FOUND.value());
        }
    }

    @DeleteMapping(value = "/eliminaPersonaConDatosJpql", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseStatusStringDto> eliminaPersonaJPQL(@RequestBody ValueLongDto valueLongDto) {

        if (this.personaService.existPersona(valueLongDto.getIdValueLongDto())) {
            ResponseStatusStringDto responseStatusStringDto;
            PersonaDto personaDto;
           
            personaDto = this.personaService.eliminaPersonaDatosJpql(valueLongDto);
            String persona= personaDto.toString();

//             responseStatusStringDto = new ResponseStatusStringDto (status, message, Integer.SIZE, stringObject);
            responseStatusStringDto = new ResponseStatusStringDto(HttpStatus.OK.name(), HttpStatus.OK.value(), "El usuario eliminado es: ", persona.toString());

            return new ResponseEntity<>(responseStatusStringDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el  usuario", HttpStatus.NOT_FOUND.value());
        }
    }
    
    ///aqui comienza el de producto
    
    @PostMapping(value = "/insertaProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValueLongDto> insertProducto(@RequestBody InsertaProductoDto insertaProductoDto)  {

        ValueLongDto valueLongDto = this.productoService.insertaProducto(insertaProductoDto);
        return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/actualizaProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValueLongDto> updateProducto(@RequestBody ActualizaProductoDto actualizaProductoDto) {

        if (this.productoService.existProduct(actualizaProductoDto.getId())) {
            ValueLongDto valueLongDto = this.productoService.actualizaProducto(actualizaProductoDto);
            return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el producto", HttpStatus.NOT_FOUND.value());
        }
    }
    
    @DeleteMapping(value = "/eliminaProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumePorString> deleteProducto(@RequestBody ValueLongDto valueLongDto) {

        if (this.productoService.existProduct(valueLongDto.getIdValueLongDto())) {
            ConsumePorString mensaje = this.productoService.eliminaProducto(valueLongDto);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el  producto", HttpStatus.NOT_FOUND.value());
        }
    }
    
    
    //aqui empieza la tienda
    @PostMapping(value = "/insertaTienda", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValueLongDto> insertTienda(@RequestBody InsertaTiendaDto insertaTiendaDto) throws SQLException {
        if (this.personaService.existPersona(insertaTiendaDto.getIdPersona()) && this.productoService.existProduct(insertaTiendaDto.getIdProducto())) {
            ValueLongDto valueLongDto = this.tiendaService.insertaTienda(insertaTiendaDto);
        return new ResponseEntity<>(valueLongDto, HttpStatus.OK);
        }else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "id de producto o persona no es valido o no existe", HttpStatus.NOT_FOUND.value());
        }
    }
    
    
    @DeleteMapping(value = "/eliminaProductoPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumePorString> deleteProPerOrTienda(@RequestBody DobleIdDto dobleIdDto) {

        
            
            if(this.personaService.existPersona(dobleIdDto.getIdPersonaDto()) ){
                ValueLongDto valueLongDto= new ValueLongDto();
                valueLongDto.setIdValueLongDto(dobleIdDto.getIdPersonaDto());
                ConsumePorString mensaje = this.personaService.eliminaPersona(valueLongDto);
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }
            if(this.productoService.existProduct(dobleIdDto.getIdProductoDto())){
                ValueLongDto valueLongDto= new ValueLongDto();
                valueLongDto.setIdValueLongDto(dobleIdDto.getIdProductoDto());
                ConsumePorString mensaje = this.productoService.eliminaProducto(valueLongDto);
                return new ResponseEntity<>(mensaje, HttpStatus.OK);
            }           
            
         else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe producto o persona", HttpStatus.NOT_FOUND.value());
        }
    }
    
    @DeleteMapping(value = "/eliminaTienda", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConsumePorString> deleteTienda(@RequestBody ValueLongDto valueLongDto) {

        if (this.tiendaService.existTienda(valueLongDto.getIdValueLongDto())) {
            ConsumePorString mensaje = this.tiendaService.eliminaTienda(valueLongDto);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe la tienda", HttpStatus.NOT_FOUND.value());
        }
    }

}
