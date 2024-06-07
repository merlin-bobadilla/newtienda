/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practica.demo.service;

import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.DobleIdDto;
import com.example.practica.demo.dto.InsertaTiendaDto;
import com.example.practica.demo.dto.TiendaEntityDto;
import com.example.practica.demo.dto.ValueLongDto;

/**
 *
 * @author mb
 */
public interface TiendaService {

    public ValueLongDto insertaTienda(InsertaTiendaDto insertaTiendaDto);

    public void deleteFirstForenkey(ValueLongDto valueLongDto);

    public void deleteFirstForenkeyProducto(ValueLongDto valueLongDto);

    public ConsumePorString eliminaTienda( ValueLongDto valueLongDt);

    public boolean existTienda(long idValueLongDto);

    public TiendaEntityDto findById(ValueLongDto valueLongDto);
    
}
