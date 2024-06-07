
package com.example.practica.demo.service;

import com.example.practica.demo.dto.ActualizaProductoDto;
import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.InsertaProductoDto;
import com.example.practica.demo.dto.PersonaDto;
import com.example.practica.demo.dto.ValueLongDto;


public interface ProductoService {

    public ValueLongDto insertaProducto(InsertaProductoDto insertaProductoDto);

    public ValueLongDto actualizaProducto(ActualizaProductoDto actualizaProductoDto);

    public boolean existProduct(long id);

    public ConsumePorString eliminaProducto(ValueLongDto valueLongDto);

    public InsertaProductoDto buscarProductoPorId(long idValueLongDto);

    
}
