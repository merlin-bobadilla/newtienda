
package com.example.practica.demo.dto;


public class ActualizaProductoDto {
    private long id;
    private InsertaProductoDto actualizaProducto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InsertaProductoDto getActualizaProducto() {
        return actualizaProducto;
    }

    public void setActualizaProducto(InsertaProductoDto actualizaProducto) {
        this.actualizaProducto = actualizaProducto;
    }

    
    
    
}
