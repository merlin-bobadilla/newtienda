
package com.example.practica.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Productos", schema = "tiendaspring")
public class ProductoEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Long id;

    @Column(name = "NOMBRE_PRODUCTO", length = 50, nullable = false)
    private String nombreProducto;
    
    @Column(name = "DESCRIPCION_PRODUCTO", length = 50, nullable = false)
    private String descricionProducto;
    
    @Column(name = "CANTIDAD")
    private Long cantidad;
    
    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade={CascadeType.ALL})
    private List<TiendaEntity> tienda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescricionProducto() {
        return descricionProducto;
    }

    public void setDescricionProducto(String descricionProducto) {
        this.descricionProducto = descricionProducto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public List<TiendaEntity> getTienda() {
        return tienda;
    }

    public void setTienda(List<TiendaEntity> tienda) {
        this.tienda = tienda;
    }


    
    
}
