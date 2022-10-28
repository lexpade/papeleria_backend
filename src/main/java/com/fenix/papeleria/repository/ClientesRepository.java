package com.fenix.papeleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenix.papeleria.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

}
