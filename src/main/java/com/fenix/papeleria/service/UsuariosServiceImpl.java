package com.fenix.papeleria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenix.papeleria.model.Usuarios;
import com.fenix.papeleria.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	private UsuariosRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuarios> findById(int id_usuarios) {
		return usuarioRepository.findById(id_usuarios);
	}
	
	@Override
	@Transactional
	public Usuarios save(Usuarios usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(int id_usuarios) {
		usuarioRepository.deleteById(id_usuarios);
	}
	
	@Override
	public List<Usuarios> findAdminById(int id_usuarios) {
		List<Usuarios> usuarios = usuarioRepository.findAdminById(id_usuarios);
		return usuarios;
	}

}
