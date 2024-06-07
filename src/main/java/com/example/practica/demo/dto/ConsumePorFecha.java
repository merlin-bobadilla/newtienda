
package com.example.practica.demo.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


public class ConsumePorFecha {
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoPersona;

    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }
    
    
}
