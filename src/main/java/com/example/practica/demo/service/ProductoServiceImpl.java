
package com.example.practica.demo.service;

import com.example.practica.demo.dto.ActualizaProductoDto;
import com.example.practica.demo.dto.ConsumePorString;
import com.example.practica.demo.dto.InsertaProductoDto;
import com.example.practica.demo.dto.ValueLongDto;
import com.example.practica.demo.entity.ProductoEntity;
import com.example.practica.demo.repository.ProductoRepository;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private TiendaService tiendaService;

    @Override
    @Transactional(rollbackFor = { SQLException.class })
    public ValueLongDto insertaProducto(InsertaProductoDto insertaProductoDto) {
        ValueLongDto id = new ValueLongDto();
        ProductoEntity productoEntity, recuperIdProducto;
        productoEntity = new ProductoEntity();
        
//        personaEntity.setId(insertaPersonaDto.getId());
        productoEntity.setNombreProducto(insertaProductoDto.getNombreProducto());
        productoEntity.setDescricionProducto(insertaProductoDto.getDescricionProducto());
        productoEntity.setCantidad(insertaProductoDto.getCantidad());
        
        recuperIdProducto = this.productoRepository.save(productoEntity);
//        throw new SQLException("Throwing exception for demoing rollback"); //aqui aplicamos el rollback para echar atras una transaccion
        id.setIdValueLongDto(recuperIdProducto.getId());
        
        
        return id;

    }

    @Override
    public ValueLongDto actualizaProducto(ActualizaProductoDto actualizaProductoDto) {
        ValueLongDto id = new ValueLongDto();
        ProductoEntity productoEntity, recuperIdProducto;

        productoEntity = this.productoRepository.findById(actualizaProductoDto.getId());
        productoEntity.setNombreProducto(actualizaProductoDto.getActualizaProducto().getNombreProducto());
        productoEntity.setDescricionProducto(actualizaProductoDto.getActualizaProducto().getDescricionProducto());
        productoEntity.setCantidad(actualizaProductoDto.getActualizaProducto().getCantidad());
        
        recuperIdProducto = this.productoRepository.save(productoEntity);
        id.setIdValueLongDto(recuperIdProducto.getId());
        return id;
        
    }

    @Override
    public boolean existProduct(long id) {
       
       return this.productoRepository.existsById(id);
    }

    @Override
    public ConsumePorString eliminaProducto(ValueLongDto valueLongDto) {
        ConsumePorString mensaje = new ConsumePorString();
        this.tiendaService.deleteFirstForenkeyProducto(valueLongDto);
//        this.productoRepository.deleteById(valueLongDto.getIdValueLongDto());
        
        mensaje.setString("producto eliminado");
        
        return mensaje;
    }

    @Override
    public InsertaProductoDto buscarProductoPorId(long idValueLongDto) {
        ProductoEntity productoEntity = this.productoRepository.findById(idValueLongDto);
        InsertaProductoDto productoDto = new InsertaProductoDto();
        productoDto.setNombreProducto(productoEntity.getNombreProducto());
        productoDto.setDescricionProducto(productoEntity.getDescricionProducto());
        productoDto.setCantidad(productoEntity.getCantidad());
        
        return productoDto;
    }

    
    
}
