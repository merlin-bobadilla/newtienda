package com.example.practica.demo.service;

import com.example.practica.demo.dto.ActualizaPersonaDto;
import com.example.practica.demo.dto.ConsumePorFecha;
import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.InsertaPersonaDto;
import com.example.practica.demo.dto.PersonaDto;
import com.example.practica.demo.dto.ValueLongDto;
import com.example.practica.demo.entity.PersonaEntity;
import com.example.practica.demo.repository.PersonaRepository;
import com.example.practica.demo.repository.TiendaRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private TiendaService tiendaService;
    
    @Override
    @Transactional(rollbackFor = { SQLException.class })
    public ValueLongDto insertaPersona(InsertaPersonaDto insertaPersonaDto) throws SQLException{
        ValueLongDto id = new ValueLongDto();
        PersonaEntity personaEntity, recuperIdPersona;
        personaEntity = new PersonaEntity();
        
//        personaEntity.setId(insertaPersonaDto.getId());
        personaEntity.setNombrePersona(insertaPersonaDto.getNombre());
        personaEntity.setApellidoPersona(insertaPersonaDto.getApellidos());
        personaEntity.setFechaNacimientoPersona(insertaPersonaDto.getFechaNacimientoPersona());
        
        recuperIdPersona = this.personaRepository.save(personaEntity);
//        throw new SQLException("Throwing exception for demoing rollback"); //aqui aplicamos el rollback para echar atras una transaccion
        id.setIdValueLongDto(recuperIdPersona.getId());
        
        
        return id;
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public PersonaDto buscarPersonaPorId(long id) {
        PersonaEntity personaEntity = this.personaRepository.findById(id);
        PersonaDto personaDto = new PersonaDto();
        personaDto.setId(personaEntity.getId());
        personaDto.setNombre(personaEntity.getNombrePersona());
        personaDto.setApellido(personaEntity.getApellidoPersona());
        
        return personaDto;
        
    }
    
    @Override
    public boolean existPersona(long id) {
        
        return this.personaRepository.existsById(id);
        
    }
    
    @Override
    public List<InsertaPersonaDto> buscaporapellido(ConsumePorString consumePorString) {
        List<InsertaPersonaDto> personas = new ArrayList<>();
        InsertaPersonaDto insertaPersonaDto;
        List<PersonaEntity> personasEntity = this.personaRepository.findPersonasApellido(consumePorString.getString());
        for (PersonaEntity personaEntity : personasEntity) {
            insertaPersonaDto = new InsertaPersonaDto();
//            insertaPersonaDto.setId(personaEntity.getId());
            insertaPersonaDto.setNombre(personaEntity.getNombrePersona());
            insertaPersonaDto.setApellidos(personaEntity.getApellidoPersona());
            insertaPersonaDto.setFechaNacimientoPersona(personaEntity.getFechaNacimientoPersona());
            personas.add(insertaPersonaDto);
        }
        return personas;
    }
    
    @Override
    public List<InsertaPersonaDto> buscaporfecha(ConsumePorFecha consumePorFecha) {
        List<InsertaPersonaDto> personas = new ArrayList<>();
        InsertaPersonaDto insertaPersonaDto;
        List<PersonaEntity> personasEntity = this.personaRepository.findPersonasFecha(consumePorFecha.getFechaNacimientoPersona());
        for (PersonaEntity personaEntity : personasEntity) {
            insertaPersonaDto = new InsertaPersonaDto();
//            insertaPersonaDto.setId(personaEntity.getId());
            insertaPersonaDto.setNombre(personaEntity.getNombrePersona());
            insertaPersonaDto.setApellidos(personaEntity.getApellidoPersona());
            insertaPersonaDto.setFechaNacimientoPersona(personaEntity.getFechaNacimientoPersona());
            personas.add(insertaPersonaDto);
            System.out.println(personas);
        }
        return personas;
        
    }
    
    @Override
    public List<InsertaPersonaDto> buscaporapellidoJpa(ConsumePorString consumePorString) {
        List<InsertaPersonaDto> personas = new ArrayList<>();
        InsertaPersonaDto insertaPersonaDto;
        List<PersonaEntity> personasEntity = this.personaRepository.findByApellidoPersonaIgnoreCase(consumePorString.getString());
//                                                                    findPersonasApellido(consumePorString.getString())
        for (PersonaEntity personaEntity : personasEntity) {
            
//            if (personaEntity.getApellidoPersona().equalsIgnoreCase(consumePorString.getString())) {
                
                insertaPersonaDto = new InsertaPersonaDto();
//                insertaPersonaDto.setId(personaEntity.getId());
                insertaPersonaDto.setNombre(personaEntity.getNombrePersona());
                insertaPersonaDto.setApellidos(personaEntity.getApellidoPersona());
                insertaPersonaDto.setFechaNacimientoPersona(personaEntity.getFechaNacimientoPersona());
                personas.add(insertaPersonaDto);
//            }
            
        }
        return personas;
        
    }

    @Override
    public ValueLongDto actualizaPersona(ActualizaPersonaDto actualizaPersonaDto) {
        
         ValueLongDto id = new ValueLongDto();
        PersonaEntity personaEntity, recuperIdPersona;

        personaEntity = this.personaRepository.findById(actualizaPersonaDto.getId());
        personaEntity.setNombrePersona(actualizaPersonaDto.getDatosPersonales().getNombre());
        personaEntity.setApellidoPersona(actualizaPersonaDto.getDatosPersonales().getApellidos());
        personaEntity.setFechaNacimientoPersona(actualizaPersonaDto.getDatosPersonales().getFechaNacimientoPersona());
        
        recuperIdPersona = this.personaRepository.save(personaEntity);
        id.setIdValueLongDto(recuperIdPersona.getId());
        
        return id;

    }

    @Override
    public ConsumePorString eliminaPersona(ValueLongDto valueLongDto) {
        ConsumePorString mensaje = new ConsumePorString();
        this.tiendaService.deleteFirstForenkey(valueLongDto);
//         this.personaRepository.deleteById(valueLongDto.getIdValueLongDto()); este ya no va porque hago la eliminacion en el tiendaServiceImpl
         mensaje.setString("usuario eliminado");

        return mensaje;
        


    }

    @Override
    public PersonaDto eliminaPersonaDatos(ValueLongDto valueLongDto) {
        PersonaDto personaDto= new PersonaDto();
        PersonaEntity personaEntity;
        
        personaEntity = this.personaRepository.findById(valueLongDto.getIdValueLongDto());
        personaDto.setId(personaEntity.getId());
        personaDto.setNombre(personaEntity.getNombrePersona());
        personaDto.setApellido(personaEntity.getApellidoPersona());
        this.personaRepository.delete(personaEntity);
        return personaDto;



    }

    @Override
    public PersonaDto eliminaPersonaDatosJpql(ValueLongDto valueLongDto) {
        PersonaDto personaDto= new PersonaDto();
        PersonaEntity personaEntity;
        
        personaEntity = this.personaRepository.findById(valueLongDto.getIdValueLongDto());
        personaDto.setId(personaEntity.getId());
        personaDto.setNombre(personaEntity.getNombrePersona());
        personaDto.setApellido(personaEntity.getApellidoPersona());
        this.personaRepository.deletePersonaId(valueLongDto.getIdValueLongDto());
        return personaDto;
        
        
        
        
    }

    

    
    
}
