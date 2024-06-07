
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Personas", schema = "tiendaspring")
public class PersonaEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private Long id;

    @Column(name = "NOMBRE_PERSONA", length = 50, nullable = false)
    private String nombrePersona;
    
    @Column(name = "APELLIDO_PERSONA", length = 50, nullable = false)
    private String apellidoPersona;
    
    
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO_PERSONA")
    private Date fechaNacimientoPersona;
    
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade={CascadeType.ALL})
    private List<TiendaEntity> tienda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    public List<TiendaEntity> getTienda() {
        return tienda;
    }

    public void setTienda(List<TiendaEntity> tienda) {
        this.tienda = tienda;
    }
     
     
    
}
