package com.example.practica.demo.repository;

import com.example.practica.demo.entity.PersonaEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    @Override
    public PersonaEntity save(PersonaEntity personaEntity);

    public PersonaEntity findById(long id);

    @Query("SELECT p FROM PersonaEntity p WHERE p.apellidoPersona LIKE ?1 ")
    public List<PersonaEntity> findPersonasApellido(String apellido);//esta variable llamda apellido se inyecta en el signo de interrogacion

    @Query("SELECT p FROM PersonaEntity p WHERE p.fechaNacimientoPersona <= ?1 ")
    public List<PersonaEntity> findPersonasFecha(Date fecha);
    
    public List<PersonaEntity> findByApellidoPersonaIgnoreCase(String apellido);
//    public List<PersonaEntity> findByApellidoPersonaIgnoreCaseStartingWithEndingWith(String apellido); //este me busca por primer letra y por ultima letra 
    
    @Modifying
    @Transactional
    @Query("DELETE FROM PersonaEntity p WHERE p.id = ?1 ")
    public void deletePersonaId(long id);//esta variable llamda apellido se inyecta en el signo de interrogacion
    
    
    
}
