package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import com.fenix.papeleria.model.Usuarios;

public interface UsuariosService {
	public List<Usuarios> findAll();
	public Optional<Usuarios> findById(int id_usuarios);
	public Usuarios save(Usuarios usuario);
	public void deleteById(int id_usuarios);
	public List<Usuarios> findAdminById(int id_usuarios);

}
