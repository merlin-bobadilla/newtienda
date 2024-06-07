/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practica.demo.repository;

import com.example.practica.demo.entity.PersonaEntity;
import com.example.practica.demo.entity.ProductoEntity;
import com.example.practica.demo.entity.TiendaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends JpaRepository<TiendaEntity, Long>{
    @Override
    public TiendaEntity save(TiendaEntity tiendaEntity);
    
    public List <TiendaEntity> findByPersona(PersonaEntity personaEntity); 
    
    public List <TiendaEntity> findByProducto(ProductoEntity productoEntity); 

    public TiendaEntity findById(long idValueLongDto);
    
}
