package com.fenix.papeleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fenix.papeleria.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
	
	@Query(value = "SELECT * FROM usuarios u WHERE u.id_usuarios = :id", nativeQuery = true)
	public List<Usuarios> findAdminById(int id);
}