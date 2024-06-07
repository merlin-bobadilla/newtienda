
package com.example.practica.demo.repository;

import com.example.practica.demo.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    @Override
    public ProductoEntity save(ProductoEntity productoEntity);
    
    public ProductoEntity findById(long id);
}
