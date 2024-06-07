
package com.example.practica.demo.service;

import com.example.practica.demo.dto.ActualizaPersonaDto;
import com.example.practica.demo.dto.ActualizaProductoDto;
import com.example.practica.demo.dto.ConsumePorFecha;
import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.InsertaPersonaDto;
import com.example.practica.demo.dto.PersonaDto;
import com.example.practica.demo.dto.ValueLongDto;
import java.sql.SQLException;
import java.util.List;


public interface PersonaService {
    public ValueLongDto insertaPersona(InsertaPersonaDto insertaPersonaDto)throws SQLException;
    public PersonaDto buscarPersonaPorId(long id);
    public boolean existPersona(long id);
    public List<InsertaPersonaDto> buscaporapellido(ConsumePorString consumePorString);

    public List<InsertaPersonaDto> buscaporfecha(ConsumePorFecha consumePorFecha);

    public List<InsertaPersonaDto> buscaporapellidoJpa(ConsumePorString consumePorString);

    public ValueLongDto actualizaPersona(ActualizaPersonaDto actualizaPersonaDto);

    public ConsumePorString eliminaPersona(ValueLongDto valueLongDto);

    public PersonaDto eliminaPersonaDatos(ValueLongDto valueLongDto);

    public PersonaDto eliminaPersonaDatosJpql(ValueLongDto valueLongDto);

 

    
}
