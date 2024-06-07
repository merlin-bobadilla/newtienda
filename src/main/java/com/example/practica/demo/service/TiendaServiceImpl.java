package com.example.practica.demo.service;

import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.DobleIdDto;
import com.example.practica.demo.dto.InsertaTiendaDto;
import com.example.practica.demo.dto.TiendaEntityDto;
import com.example.practica.demo.dto.ValueLongDto;
import com.example.practica.demo.entity.PersonaEntity;
import com.example.practica.demo.entity.ProductoEntity;
import com.example.practica.demo.entity.TiendaEntity;
import com.example.practica.demo.repository.PersonaRepository;
import com.example.practica.demo.repository.ProductoRepository;
import com.example.practica.demo.repository.TiendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ValueLongDto insertaTienda(InsertaTiendaDto insertaTiendaDto) {

        TiendaEntity tiendaEntity = new TiendaEntity();
        ProductoEntity productoEntity = this.productoRepository.findById(insertaTiendaDto.getIdProducto());
        PersonaEntity personaEntity = this.personaRepository.findById(insertaTiendaDto.getIdPersona());

        tiendaEntity.setPersona(personaEntity);
        tiendaEntity.setProducto(productoEntity);
        tiendaEntity.setNombreTienda(insertaTiendaDto.getNombreTienda());

        TiendaEntity recuperaIdTienda = this.tiendaRepository.save(tiendaEntity);

        ValueLongDto valueLongDto = new ValueLongDto();
        valueLongDto.setIdValueLongDto(recuperaIdTienda.getId());

        return valueLongDto;
    }

    @Override
    public void deleteFirstForenkey(ValueLongDto valueLongDto) {
        PersonaEntity personaEntiyt = this.personaRepository.findById(valueLongDto.getIdValueLongDto());

        List<TiendaEntity> tiendasEntity = this.tiendaRepository.findByPersona(personaEntiyt);
        for (TiendaEntity tiendaEntity : tiendasEntity) {
            tiendaEntity.setPersona(null);
            tiendaRepository.save(tiendaEntity);
        }
        this.personaRepository.delete(personaEntiyt);
    }

    @Override
    public void deleteFirstForenkeyProducto(ValueLongDto valueLongDto) {
        ProductoEntity productoEntity = this.productoRepository.findById(valueLongDto.getIdValueLongDto());

        List<TiendaEntity> tiendasEntity = this.tiendaRepository.findByProducto(productoEntity);

        for (TiendaEntity tiendaEntity : tiendasEntity) {
            tiendaEntity.setProducto(null);
            tiendaRepository.save(tiendaEntity);
        }

        this.productoRepository.delete(productoEntity);

    }

    @Override
    public boolean existTienda(long idValueLongDto) {

        return this.tiendaRepository.existsById(idValueLongDto);

    }

    @Override
    public ConsumePorString eliminaTienda(ValueLongDto valueLongDt) {
        ConsumePorString mensaje = new ConsumePorString();
        TiendaEntity tiendaEntity = this.tiendaRepository.findById(valueLongDt.getIdValueLongDto());
        tiendaEntity.setPersona(null);
        tiendaEntity.setProducto(null);
        this.tiendaRepository.save(tiendaEntity);
        this.tiendaRepository.delete(tiendaEntity);
        mensaje.setString("tienda eliminada");
        return mensaje;

    }

    @Override
    public TiendaEntityDto findById(ValueLongDto valueLongDto) {
        TiendaEntityDto tiendaEntityDto = new TiendaEntityDto();
        TiendaEntity tiendaEntity = this.tiendaRepository.findById(valueLongDto.getIdValueLongDto());
        if (tiendaEntity.getPersona() == null && tiendaEntity.getProducto() == null) {
            tiendaEntityDto.setNombreTienda(tiendaEntity.getNombreTienda());
            tiendaEntityDto.setNombreProducto(null);
            tiendaEntityDto.setNombrePersona(null);
            return tiendaEntityDto;
        } else if (tiendaEntity.getPersona() == null) {
            tiendaEntityDto.setNombreTienda(tiendaEntity.getNombreTienda());
            tiendaEntityDto.setNombreProducto(tiendaEntity.getProducto().getNombreProducto());
            tiendaEntityDto.setNombrePersona(null);
            return tiendaEntityDto;
        } else {

            tiendaEntityDto.setNombreTienda(tiendaEntity.getNombreTienda());
            tiendaEntityDto.setNombreProducto(null);
            tiendaEntityDto.setNombrePersona(tiendaEntity.getPersona().getNombrePersona());
            return tiendaEntityDto;
        }
    }

}
