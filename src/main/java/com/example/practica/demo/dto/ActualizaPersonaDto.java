
package com.example.practica.demo.dto;


public class ActualizaPersonaDto {
    
    private long id;
    
    private InsertaPersonaDto datosPersonales;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InsertaPersonaDto getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(InsertaPersonaDto datosPersonales) {
        this.datosPersonales = datosPersonales;
    }
    
    
}
