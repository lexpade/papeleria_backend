package com.fenix.papeleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenix.papeleria.model.Proveedores;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, String> {

}
