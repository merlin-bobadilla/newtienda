
package com.example.practica.demo.dto;


public class InsertaProductoDto {
    private String nombreProducto;
    private String descricionProducto;
    private Long cantidad;

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
    
    
}
