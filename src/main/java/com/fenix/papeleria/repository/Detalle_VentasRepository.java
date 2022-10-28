package com.fenix.papeleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenix.papeleria.model.Detalle_Ventas;

@Repository
public interface Detalle_VentasRepository extends JpaRepository<Detalle_Ventas, Integer>{

}
