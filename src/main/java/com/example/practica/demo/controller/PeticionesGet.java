package com.example.practica.demo.controller;

import com.example.practica.demo.dto.ConsumePorFecha;
import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.InsertaPersonaDto;
import com.example.practica.demo.dto.InsertaProductoDto;
import com.example.practica.demo.dto.PersonaDto;
import com.example.practica.demo.dto.TiendaEntityDto;
import com.example.practica.demo.dto.ValueLongDto;
import com.example.practica.demo.exception.RequestException;
import com.example.practica.demo.service.PersonaService;
import com.example.practica.demo.service.ProductoService;
import com.example.practica.demo.service.TiendaService;
import com.example.practica.demo.util.StringValidateService;
import java.util.List;
import static org.hibernate.query.sqm.tree.SqmNode.log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequestMapping("/peticionesget")
@RestController
public class PeticionesGet {

//    Logger logger = LoggerFactory.getLogger(PeticionesGet.class);
//    Logger logger = (Logger) LogManager.getLogger(PeticionesGet.class);

    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private StringValidateService stringValidateService;
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private TiendaService tiendaService ;

    @GetMapping(value = "/buscaPorPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDto> getPersonaById(@RequestBody ValueLongDto valueLongDto) {
        log.debug("iniciando el servicio de busqueda de persona");
        if (this.personaService.existPersona(valueLongDto.getIdValueLongDto())) {
            PersonaDto personaDto = this.personaService.buscarPersonaPorId(valueLongDto.getIdValueLongDto());
            return new ResponseEntity<>(personaDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el Id del usuario", HttpStatus.NOT_FOUND.value());
        }

    }

    @GetMapping(value = "/buscaPorJPQL", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InsertaPersonaDto>> getPersonaByIjpql(@RequestBody ConsumePorString consumePorString) {
        if(stringValidateService.isNull(consumePorString.getString())){
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "ingresa un nombre de usuario", HttpStatus.NOT_FOUND.value());
        }else{
           List<InsertaPersonaDto> personasDto = this.personaService.buscaporapellido(consumePorString);

            return new ResponseEntity<>(personasDto, HttpStatus.OK);
        }
        

    }

    @GetMapping(value = "/buscaPorfecha", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InsertaPersonaDto>> getPersonaByFecha(@RequestBody ConsumePorFecha consumePorFecha) {
//        log.debug(consumePorFecha.getFechaNacimientoPersona());
        List<InsertaPersonaDto> personasDto = this.personaService.buscaporfecha(consumePorFecha);

        return new ResponseEntity<>(personasDto, HttpStatus.OK);

    }
    
    @GetMapping(value = "/buscaPorJPA", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InsertaPersonaDto>> getPersonaApellidoByJpa(@RequestBody ConsumePorString consumePorString) {
        List<InsertaPersonaDto> personasDto = this.personaService.buscaporapellidoJpa(consumePorString);
        if(personasDto.isEmpty()){
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el usuario", HttpStatus.NOT_FOUND.value());
        }else{
            
            return new ResponseEntity<>(personasDto, HttpStatus.OK);
        }
        

    }

    

//     @GetMapping(value = "/buscaPorquerynativ", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<PersonaDto> getPersonaById(@RequestBody ValueLongDto valueLongDto) {
//        logger.debug("iniciando el servicio de busqueda de persona");
//        if (this.personaService.existPersona(valueLongDto.getIdValueLongDto())) {
//            PersonaDto personaDto = this.personaService.buscarPersonaPorId(valueLongDto.getIdValueLongDto());
//            return new ResponseEntity<>(personaDto, HttpStatus.OK);
//        }else{
//            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el Id del usuario", HttpStatus.NOT_FOUND.value());
//        }
//
//    }
    
    //aqui comienza lo de producto . busca por producto id
    @GetMapping(value = "/buscaPorProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InsertaProductoDto> getProductoById(@RequestBody ValueLongDto valueLongDto) {
        log.debug("iniciando el servicio de busqueda de persona");
        if (this.productoService.existProduct(valueLongDto.getIdValueLongDto())) {
            InsertaProductoDto ProductoDto = this.productoService.buscarProductoPorId(valueLongDto.getIdValueLongDto());
            return new ResponseEntity<>(ProductoDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe el ID del producto", HttpStatus.NOT_FOUND.value());
        }

    }
    
    @GetMapping(value = "/buscaTiendaPorId", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TiendaEntityDto> getTiendaById(@RequestBody ValueLongDto valueLongDto) {
        if (this.tiendaService.existTienda(valueLongDto.getIdValueLongDto())) {
            TiendaEntityDto tiendaEntityDto = this.tiendaService.findById(valueLongDto);
            return new ResponseEntity<>(tiendaEntityDto, HttpStatus.OK);
        } else {
            throw new RequestException(HttpStatus.NOT_FOUND.name(), "No existe la tienda", HttpStatus.NOT_FOUND.value());
        }

    }
    
}
