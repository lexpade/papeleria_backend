package com.fenix.papeleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenix.papeleria.model.Detalle_Compras;

@Repository
public interface Detalle_ComprasRepository extends JpaRepository<Detalle_Compras, Integer> {

}
