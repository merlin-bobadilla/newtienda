
package com.example.practica.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;



@Entity
@Table(name = "Tienda", schema = "tiendaspring")
public class TiendaEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIENDA")
    private Long id;

    @Column(name = "NOMBRE_TIENDA", length = 50, nullable = false)
    private String nombreTienda;
    
    @ManyToOne
    @JoinColumn(name = "FK_PERSONA")
    private PersonaEntity persona;
    
    @ManyToOne
    @JoinColumn(name = "FK_PRODUCTO")
    private ProductoEntity producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

   

    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }
    
    
    
    
}
