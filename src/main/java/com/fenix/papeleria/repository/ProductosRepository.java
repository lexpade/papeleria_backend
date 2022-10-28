package com.fenix.papeleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenix.papeleria.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer>{

}
